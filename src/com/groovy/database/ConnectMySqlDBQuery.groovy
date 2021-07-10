package com.groovy.database

@Grapes([
	@Grab(group='mysql', module='mysql-connector-java', version='8.0.16'),
	@Grab(group='org.codehaus.groovy', module='groovy-sql', version='3.0.8')
])

import groovy.sql.Sql
import java.util.Formatter.DateTime

def sql=  Sql.newInstance("jdbc:mysql://localhost:3306/hibdb",
	"root","admin","com.mysql.cj.jdbc.Driver")

// Query data from hibdb.person table
println ""
println " query all rows =============== "
sql.eachRow('SELECT * FROM hibdb.person') {
	println "id: ${it.id}, name: ${it.name}, location: ${it.location} " +
			"birth_date :  ${it.birth_date}"
  }

  println ""
  println " where query ==============="
  sql.eachRow('SELECT * FROM hibdb.person where id > 10004') {
	  println "id: ${it.id}, name: ${it.name}, location: ${it.location} " +
			  "birth_date :  ${it.birth_date}"
	}
  
	println ""
	println " first row from table ==============="
	def row = sql.firstRow('SELECT id,name, location,birth_date  FROM hibdb.person') 
	println "id: ${row.id}, name: ${row.name}, location: ${row.location} " +
				"birth_date :  ${row.birth_date}"
	  
	println ""
	println " update  10006 and delete 10005 ==============="
  
	def new_location='Goa'
	sql.executeUpdate("update person set location= ${new_location} where id=10006")
	
	def delete_id=10005
	sql.executeUpdate("delete from person where id=${delete_id}")
	
	println ""
	println " where query after update id 10006==============="
	sql.eachRow('SELECT * FROM hibdb.person where id = 10006') {
		println "id: ${it.id}, name: ${it.name}, location: ${it.location} " +
				"birth_date :  ${it.birth_date}"
	  }
	
	  
sql.close()

