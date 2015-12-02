package model

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Key
import groovyx.gaelyk.datastore.Unindexed
import groovyx.gaelyk.datastore.Ignore
 
@Entity(unindexed=false)
class User {
	@Key String userName
	String token
	String firstName
	String lastName
}