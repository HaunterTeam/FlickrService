# FlickrService

REST Web service for image retrieval from Flickr. It is hosted on [https://restinflickrservice.herokuapp.com](https://restinflickrservice.herokuapp.com). Given the name of a food or dish (e.g. "pizza"), it provides in output a json object with the url of a beautiful photo taken from Flickr.

Request:
```
GET http://restinflickrservice.herokuapp.com/flickr-project/flickr/pizza
```
Response:
```
{
  "url" : "https://farm3.static.flickr.com/2362/2150948508_952e86b81e_b.jpg",
  "id" : "2150948508",
  "dateAdded" : null,
  "description" : null,
  "title" : "Pizza"
}
```

Contributors: [Mirko Morandi](https://github.com/les69) 100%
