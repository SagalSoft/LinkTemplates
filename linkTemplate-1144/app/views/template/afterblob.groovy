import groovyx.gaelyk.logging.GroovyLogger
import com.google.appengine.api.blobstore.BlobKey

def key = params.key
def log = new GroovyLogger("myLogger")
log.info "Llega al controller"

def blob = new BlobKey(params.key)
blob.serve(response)

