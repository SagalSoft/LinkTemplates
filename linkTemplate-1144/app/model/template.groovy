package model

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Key
import groovyx.gaelyk.datastore.Unindexed
import groovyx.gaelyk.datastore.Ignore
 
@Entity(unindexed=false)
class Template {
	@Key long id
	String name
	Date creationDate
	Date lastModifiedDate
	String description
	String urlPreview
	String html
	User user

}