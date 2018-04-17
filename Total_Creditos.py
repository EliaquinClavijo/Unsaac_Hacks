from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from PIL import Image
import pytesseract
import pymongo 
from pymongo import MongoClient
from optparse import OptionParser

parser = OptionParser()

parser.add_option('--Cod',dest = 'name')
parser.add_option('--Pass',dest = 'pas')


(options,args) = parser.parse_args()


pytesseract.pytesseract.tesseract_cmd = 'C://Program Files (x86)//Tesseract-OCR//tesseract'
client = MongoClient('localhost', 27017)
db = client['UnsaacDB']
user = options.name
pwd = options.pas
Contras = db.Contras

driver = webdriver.Chrome()
H = True
while (True):
    if (len(user) != 6):
        print("Error")
        break
    driver.get("http://ccomputo.unsaac.edu.pe/alumno/")
    assert "UNSAAC" in driver.title
    elem = driver.find_element_by_id("user")
    elem.send_keys(user)
    elem = driver.find_element_by_id("pass")
    elem.send_keys(str(pwd))
    driver.save_screenshot("C://data//screenshot.png")
    img= Image.open("C://data//screenshot.png")
    img_recortada = img.crop((633,310,736,350))
    foto = img_recortada
    datos = foto.getdata()
    promedio = [(datos[x][0] + datos[x][1] + datos[x][2]) // 3 for x in range(len(datos))]
    imagen_gris = Image.new('L', foto.size)
    imagen_gris.putdata(promedio)
    datos = imagen_gris.getdata()

    h = []
    for x in range(0,len(datos),103):
        hh = []
        for y in range(0,103):
            l = round(((datos[x+y])/360),5)
            if l > 0.449:
                l = 255
            else:
                l = 0

            hh.append(l)
        h.append(hh)

    img = Image.new('RGB', (103, 40), "white")
    pixels = img.load();
    for i in range(img.size[1]):
        for j in range(img.size[0]):
            val = h[i][j]
            pixels[j, i] = (val, val, val);
    text = pytesseract.image_to_string(img)
    elem = driver.find_element_by_id("security_code")
    elem.send_keys(text)
    elem.send_keys(Keys.RETURN)
        
        #print(driver.page_source,"\n")
    if ("Bienvenido" in driver.page_source):
        #print("PASS : ",pwd,"\n")
        L = db.Contras.find({'CodE':user})
        if (L.count() == 0):
            post_data = {
                'CodE': user,
                'Pass': pwd
            }
            result = Contras.insert_one(post_data)
        break
    if ("Clave Incorrecta" in driver.page_source):
        print("Contraseña Incorrecta \n")
        H = False
        break
    if ("Alumno No Existe" in driver.page_source):
        print("El Alumno No Existe \n")
        H = False
        break

if (H):
    elem = driver.find_elements_by_xpath("//*[@id='principal']/li[2]/ul/li[2]/a")
    dir_alumno = ""
    for t in elem:
        dir_alumno = t.get_attribute('href')
        break
    driver.get(dir_alumno)
    select = driver.find_element_by_name("semestre")
    options = [x for x in select.find_elements_by_tag_name("option")]
    G = []
    for element in options:
        G.append(element.get_attribute("value"))
    G.reverse()

    Cat  = []
    Nro = []
    Cant = []

    for x in G:
        limit = 0
        if int(x[0:4]) < 2016:
            limit = 11
        else:
            limit = 14
        driver.get(dir_alumno)
        el = driver.find_element_by_id("semestre")
        for option in el.find_elements_by_tag_name('option'):
            if option.text == x:
                option.click()
        driver.find_element_by_xpath("//*[@id='cliente']/form/table/tbody/tr[2]/td/input").click()
        elems = driver.find_elements_by_xpath("//tr[@bgcolor='#FFFFFF']")
        for row in elems:
            cells = row.find_elements_by_tag_name("td")
            Tip = cells[4].text
            NrCred = int(cells[3].text)
            Not = float(cells[10].text)
            if Tip not in Cat:
                Cat.append(Tip)
                if Not >=limit:
                    Cant.append(NrCred)
                    Nro.append(1)
                else:
                    Cant.append(0)
                    Nro.append(0)
            else:
                Pos = Cat.index(Tip)
                if Not >=limit:
                    Cant[Pos]+= NrCred
                    Nro[Pos]+=1
    Cred_Tot = 0
    Curs_Tot = 0
    for x in range(0,len(Cat)):
        Cred_Tot+= Cant[x]
        Curs_Tot+= Nro[x]
        print("Categoria :",Cat[x],"Cantidad Creditos :",Cant[x])
        
    print("Creditos Totales : ",Cred_Tot)
    print("Cursos Totales : ",Curs_Tot)
    print("End")
driver.close()          
        

            
        



