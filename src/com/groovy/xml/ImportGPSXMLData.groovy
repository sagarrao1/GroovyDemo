package com.groovy.xml

// https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-xml
@Grapes(
	@Grab(group='org.codehaus.groovy', module='groovy-xml', version='3.0.8')
)

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
gpx.rte.rtept.each { 
	println it.@lat
	println it.@lon
	println it.time
}
