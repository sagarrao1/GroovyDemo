package com.groovy.xml

// https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-xml
@Grapes(
	@Grab(group='org.codehaus.groovy', module='groovy-xml', version='3.0.8')
)

def file= new File('C:\\PracticeJava\\GroovyDemo\\data\\fells_loop.gpx')
println file.exists()
def slurper = new XmlSlurper()
def gpx= slurper.parse(file)

def markupBuilder=  new groovy.xml.StreamingMarkupBuilder()
def xml= markupBuilder.bind{
	route {
		mkp.comment(gpx.name)
		gpx.rte.rtept.each { point ->
			routPoint(timeStamp: point.time.toString()) {
				lattitude(point.@lat)
				longitude(point.@lon)
				desc(point.desc)
			}
		}
	}
}

def outFile=  new File('C:\\PracticeJava\\GroovyDemo\\data\\fells_loop_truncated.xml')
outFile.write(xml.toString())