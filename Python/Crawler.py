#	1.Crawler,which fetches webpages from the given url.
#	2.Parses all the links on that page and make one list/repository.
#	3.Now fetch contents of any of the url from the list/repository just created.
#	4.Parse the links from this new contents into the repository until stopped or
#	  after predefined hopes/depth traversed.

from urllib2 import urlopen
from HTMLParser import HTMLParser

class Crawler(HTMLParser):
	'''
	storage is used to make a dictionary which gives us link is appeared x no. of times.
	page_source stores all the links from selected url.
	'''
	def __init__(self, url, hopes, max_links):
		HTMLParser.__init__(self)
		self.url = url
		self.storage = {self.url:1}
		self.page_source = [self.url]
		
		self.hopes = hopes
		self.max_links = max_links
		self.no_of_links = 0
		
	def handle_starttag(self, tag, attrs):
		'''
		The tag argument is the name of the tag converted to lower case.
		The attrs argument is a list of (name, value) pairs containing the attributes found inside the tag's <> brackets.
		'''
		if self.no_of_links < self.max_links and tag == 'a' and attrs:
			link = attrs[0][1]
			if link[:4] != 'http':
				link = "/".join(self.url.split('/')[:3]) + ('/'+link).replace('//','/')
			
			if link not in self.storage:
				print "New Link Found  >  %s" % link
				self.no_of_links += 1
				self.page_source.append(link)
			self.storage[link] = (self.storage.get(link) or 0) + 1
			#print self.storage
				
	def find(self):
		for d in range(self.hopes):
			print "#"*50+("\nScanning hope %d \n" % (d+1))+"#"*50
			context_source = self.page_source[:]
			self.page_source = []
			for self.url in context_source:
				self.no_of_links = 0
				try:
					request = urlopen(self.url)
					result = request.read()	# It will read entire source and store it in result which is of type str
					#print result
					self.feed(result)	#feed(result) will internally feed data to handle_starttag()
				except:
					self.reset()
		print "#"*40 + "\nRESULTS\n" + "#"*40
		output = [(v,k) for (k,v) in self.storage.items()]
		output.sort(reverse = True)
		return output
			
def main():
	
	return 0

if __name__ == '__main__':
	main()
	s = Crawler("http://python.org",2,10)
	r = s.find()
	for (n,l) in r:
		print "%s was found %d time%s." %(l,n, "s" if n is not 1 else "")
