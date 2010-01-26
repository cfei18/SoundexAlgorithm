#! /usr/bin/env python

from urllib2 import urlopen, HTTPError

string = raw_input("Please enter a string: ")

"""We need to make sure the user input string contains only letters.  The
   Soundex algorithm is not defined for string containing non-alphabetical 
   characters.  If a user enters such an invalid string, the program terminates.
"""
if not string.isalpha():
	print 'ERROR: Make sure your string contains only letters!'
	exit()

try:
	f = urlopen('http://localhost:8080/SoundexaExercise/soundex?input='+string)
	print string.upper() + ' yields ' + f.read(4) + ' via Soundex'
except HTTPError, e: #Handles HTTP errors like 404 - Not Found, 403 - Forbidden, etc
	print 'Error code: '+str(e.code)
	if e.code==404:
		print 'URL not found\nMake sure the Soundex webservice is running at
		print '\thttp://localhost:8080/SoundexExercise'
	else:
		print 'Unknown error'		
