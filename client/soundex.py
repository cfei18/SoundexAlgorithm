#! /usr/bin/env python

import re
from urllib2 import urlopen, HTTPError

string = raw_input("Please enter a string: ")
if string.isalpha():
	print 'Good!'
else:
	print 'ERROR: Make sure your string contains only letters!'
	exit()

try:
	f = urlopen('http://localhost:8080/Soundex2/soundex?input='+string)
	print string.upper() + ' yields ' + f.read(4) + ' via Soundex'
except HTTPError, e:
	print 'Error code: '+str(e.code)
	if e.code==404:
		print 'URL not found'
	else:
		print 'Unknown error'		
