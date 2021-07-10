package com.groovy.unittest

@Grapes(
	@Grab(group='joda-time', module='joda-time', version='2.10.6')
)

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class DateParser {
	
	def String parseTime(def ptime) {
		if (ptime == null) {
			throw new IllegalArgumentException()
		}
				
		def printableTime= new DateTime(ptime)
		def format= DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm aa')
		return printableTime.toString(format)
	}
}
