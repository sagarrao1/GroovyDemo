package com.groovy.database

@Grapes([
	@Grab(group='mysql', module='mysql-connector-java', version='8.0.16'),
	@Grab(group='org.codehaus.groovy', module='groovy-sql', version='3.0.8')
])

import groovy.sql.Sql
import java.util.Formatter.DateTime

def sql=  Sql.newInstance("jdbc:mysql://localhost:3306/hibdb",
	"root","admin","com.mysql.cj.jdbc.Driver")

//insert into hibdb.person table in mysql DB
def person= sql.dataSet("person")
person.add(id: '10005',name:'Sagar',location:'Karimnagar',
	birth_date: new Date())

sql.close()

