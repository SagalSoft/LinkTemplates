html.html {
	head {
		title 'Sample to Resize Images on Google App Engine'
	}
	body {
		h1 'Sample to Resize Images on Google App Engine'
		form action: '/views/template/upload.groovy', method: 'post', enctype: 'multipart/form-data', {
			label 'Photo: ', {
				input type: 'file', name: 'photo'
			}
			br()
			label 'Flip horizontally', {
				input type: 'checkbox', name:'flipHorizontal', checked:true
			}
			br()
			label 'Flip vertically', {
				input type: 'checkbox', name:'flipVertical'
			}
			br()
			label 'Rotate degress clockwise: ', {
				select name: 'rotation', {
					option '0'
					option '90'
					option '180'
					option '270'
				}
			}
			br()
			label "I'm feeling lucky", {
				input type: 'checkbox', name:'feelLucky'
			}
			hr()
			label 'Size: ', {
				select name: 'imageSize', {
					option 'thumb'
					option 'medium'
					option 'large'
				}
			}
			br()
			label 'Custom Size - width', {
				input type:'text', name:'customWidth'
			}
			br()
			label 'Custom Size - height', {
				input type:'text', name:'customHeight'
			}
			br()
			input type: 'submit', name: 'submit', value: 'Resize'
		}
	}
}