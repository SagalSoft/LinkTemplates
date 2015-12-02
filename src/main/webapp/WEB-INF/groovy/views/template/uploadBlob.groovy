import groovyx.gaelyk.logging.GroovyLogger

def log = new GroovyLogger("myLogger")
log.info "This is a logging message with level INFO"

def blobs = blobstore.getUploadedBlobs(request)
def blob = blobs["image"]

response.status = 302

if(blob){
	log.info "encuentra en blob con key ${blob.keyString}"
	redirect "/blob/success/${blob.keyString}"
}
else
{
	log.info "no encuentra el blob"
	redirect "/templates"
}