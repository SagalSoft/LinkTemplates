mport org.apache.commons.io.IOUtils
import org.apache.commons.fileupload.util.Streams
import org.apache.commons.fileupload.servlet.ServletFileUpload
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.appengine.api.images.CompositeTransform;
 
/* gets image upload. From Mr. Haki's blog - http://mrhaki.blogspot.com/2009/11/add-file-upload-support-to-groovlets-in.html */
uploads = [:]  // Store result from multipart content.
if (ServletFileUpload.isMultipartContent(request)) {
 def uploader = new ServletFileUpload()  // Cannot use diskbased fileupload in Google App Engine!
 def items = uploader.getItemIterator(request)
 while (items.hasNext()) {
 def item = items.next()
 def stream = item.openStream()
 try {
 if (item.formField) {  // 'Normal' form field.
 params[item.fieldName] = Streams.asString(stream)
 } else {
 uploads[item.fieldName] = [
 name: item.name,
 contentType: item.contentType,
 data: IOUtils.toByteArray(stream)
 ]
 }
 } finally {
 IOUtils.closeQuietly stream
 }
 }
}
/* end upload processing */
 
if (params.submit) {
 
 // Gaelyk provides a shortcut to the image service, but all the heavy lifting is done by the ImagesServiceFactory.
 
 // get original image
 Image pic = ImagesServiceFactory.makeImage( uploads['photo'].data )
 
 // we can use a composite transform to store a series of transformations
 CompositeTransform cp = ImagesServiceFactory.makeCompositeTransform()
 
 // add a horizontal flip
 if( params.flipHorizontal == 'on'){
 cp.concatenate( ImagesServiceFactory.makeHorizontalFlip() )
 }
 
 // vertical flip
 if( params.flipVertical == 'on'){
 cp.concatenate( ImagesServiceFactory.makeVerticalFlip() )
 }
 
 // rotate image - note, this can only happen in increments of 90 degrees
 if( params.rotation ){
 cp.concatenate( ImagesServiceFactory.makeRotate( params.rotation as int ) )
 }
 
 // I'm feeling lucky - which provides image balancing
 if( params.feelLucky == 'on' )
 {
 cp.concatenate( ImagesServiceFactory.makeImFeelingLucky() )
 }
 
 // resizing tranformations
 Transform resize
 
 // first deal with cases where there is no custom width/ height specified
 if( !params.customWidth ){
 switch( params.imageSize ){
 case 'thumb':
 resize = ImagesServiceFactory.makeResize(50,50);
 break;
 case 'medium':
 resize = ImagesServiceFactory.makeResize(200,200);
 break;
 case 'large':
 resize = ImagesServiceFactory.makeResize(400,400);
 break;
 }
 } else {
 
 // handle case where there is a specified height / width
 
 resize = ImagesServiceFactory.makeResize( params.customWidth as int, params.customHeight as int)
 }
 cp.concatenate( resize )
 
 // apply all the transformations to the original image
 // images is a Gaelyk shortcut for imageService. Personally, I think it should map to imagesServiceFactory
 pic = images.applyTransform( cp, pic )
 
 // set response type
 response.setContentType( uploads['photo'].contentType )
 
 // render image out
 sout << pic.imageData
 
}