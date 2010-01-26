#! /usr/bin/env python

from urllib2 import urlopen, HTTPError

string = raw_input("Please enter a string: ")
if not string.isalpha():
	print 'ERROR: Make sure your string contains only letters!'
	exit()

try:
	f = urlopen('http://localhost:8080/Soundex/soundex?input='+string)
	print string.upper() + ' yields ' + f.read(4) + ' via Soundex'
except HTTPError, e:
	print 'Error code: '+str(e.code)
	if e.code==404:
		print 'URL not found'
	else:
		print 'Unknown error'		
