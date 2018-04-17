import pymongo 
from pymongo import MongoClient
import wget
from selenium import webdriver
from selenium.webdriver.common.keys import Keys


client = MongoClient()
client = MongoClient('localhost', 27017)
db = client['UnsaacDB']
driver = webdriver.Chrome()
"""

driver.get("http://ccomputo.unsaac.edu.pe/?op=catalog")
elem1 = driver.find_elements_by_xpath("//*[@id='hor-minimalist-b']/tbody")
#CP = db.CP
Carr = []
for y in elem1:
    for x in y.find_elements_by_tag_name("tr"):
        cells = x.find_elements_by_tag_name("td")
        elem = cells[2].find_elements_by_tag_name("a")
        for t in elem:
            Carr.append(t.get_attribute('href'))
            #post_data = {
            #'Cod': cells[0].text,
            #'Name': cells[1].text,
            #'Link': t.get_attribute('href')
            #}
            #result = CP.insert_one(post_data)
            break
cod = 1
tot = 0
#Cursos = db.Cursos
for xx in Carr:
    driver.get(xx)
    elems = driver.find_elements_by_xpath("//tr[@style='background-color:#F0F0F0; border-bottom:#03C;border-width:3px']")
    for row in elems:
        cells = row.find_elements_by_tag_name("td")
        #post_data = {
        #'CodCP': cod,
        #'CodC': cells[1].text,
        #'Name': cells[2].text,
        #'Credit': cells[4].text,
        #'Cat': cells[5].text
        #}
        #result = Cursos.insert_one(post_data)
        tot+=1
    print(tot)
    cod+=1
"""
NA = 0
AlumCurs = db.AlumCurs
Alumnos = db.Alumnos
L = db.Cursos.find()
for post in L:
    H = (post['CodC'])
    driver.get("http://ccomputo.unsaac.edu.pe/?op=alcurso")
    elem = driver.find_element_by_id("curso")
    elem.clear()
    elem.send_keys(H)
    elem.send_keys(Keys.RETURN)
    #Dat = driver.find_elements_by_xpath("//*[@id='main_container']/div[3]/div/table/tbody")
    #for y in Dat:
    #    for x in y.find_elements_by_tag_name("tr"):
    #        cells = x.find_elements_by_tag_name("td")
    #        print(cells[0].text,cells[1].text,cells[2].text,cells[3].text)
    
    Alumn = driver.find_elements_by_xpath("//*[@bgcolor]")
    for row in Alumn:
        cells = row.find_elements_by_tag_name("td")
        post_data = {
            'CodC': H,
            'CodE': cells[1].text
        }
        result = AlumCurs.insert_one(post_data)
        L = db.Alumnos.find({'CodE':cells[1].text})
        if (L.count() == 0):
            post_data = {
                'CodE': cells[1].text,
                'Name': cells[2].text
            }
            result = Alumnos.insert_one(post_data)
            NA+=1
    print(NA)




