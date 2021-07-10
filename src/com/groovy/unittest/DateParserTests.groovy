package com.groovy.unittest

@Grapes(
	@Grab(group='joda-time', module='joda-time', version='2.10.6')
)

import com.groovy.unittest.DateParser
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.joda.time.DateTime
import static org.junit.Assert.*

class DateParserTests extends GroovyTestCase{
	def parser 

	@Before
	def void setUp(){
		parser= new DateParser()
	}

	@After
	def void tearDown() {
		parser= null
	}

	@Test
	public void testParseTime() {
//		def parser= new DateParser()
		def iTime= new DateTime(2013,1,1,9,30)
		def result =  parser.parseTime(iTime.toString())
		
		assert "01/01/2013 - 09:30 AM" == result		
	}

	@Test
	def void testParseTimeWIthNull() {
//		def parser= new DateParser()
		
		shouldFail(IllegalArgumentException) {
			parser.parseTime(null)
		}
	}

}
