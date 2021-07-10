package com.groovy.unittest
// https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-xml
@Grapes([
	@Grab(group='org.codehaus.groovy', module='groovy-xml', version='3.0.8'),
	@Grab(group='joda-time', module='joda-time', version='2.10.6')
])


import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

def file= new File('C:\\PracticeJava\\GroovyDemo\\data\\fells_loop.gpx')
println file.exists()
def slurper = new XmlSlurper()
def gpx= slurper.parse(file)
println gpx.name
println ''
println gpx.desc
println ''
println gpx.@version
println gpx.@creator
println ''

//for (point in gpx.rte.rtept) {
//	println point.@lat
//	println point.@lon
//	println point.time
//}
// Another way of using closure 
// Use Java DateTime class to format time
gpx.rte.rtept.each { 
	println it.@lat
	println it.@lon
//	println it.time
	
//	def printableTime= new DateTime(it.time.toString())
//	def format= DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm aa')
//	println printableTime.toString(format)
	
	def parser= new DateParser()
	println parser.parseTime(it.time.toString())
	
}
