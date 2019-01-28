# Springboot - JMS

This application uses:
1. SpringBoot 2
2. ReactiveMongo
3. JmsTemplate (ActiveMQ)
4. Mongo ATLAS (Mongo cluster on cloud)

# App URL

Resources: `acquisition`, `instrument`

API access at: https://jms-jr.herokuapp.com/api/v1/[resources]

Swagger access at: https://jms-jr.herokuapp.com/swagger-ui.html

Swagger Doc access at: https://jms-jr.herokuapp.com/v2/api-docs

# Endpoints

Resources (examples to use and test): 

`POST`

### Instruments

```json
{
	"name":"SJC Pluviometer Station",
	"code":"JR2019"
}
```

##### JS

```js
var settings = {
"async": true,
"crossDomain": true,
"url": "http://localhost:8090/api/v1/instrument",
"method": "POST",
"headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",
    "postman-token": "60e655ce-5e78-fc42-7355-eb8bb58df893"
},
"processData": false,
"data": "{\n\t\"name\":\"SJC Pluviometer Station\",\n\t\"code\":\"JR2019\"\n}"
}

$.ajax(settings).done(function (response) {
console.log(response);
});
```

##### CURL

```sh
curl -X POST \
http://localhost:8090/api/v1/instrument \
-H 'cache-control: no-cache' \
-H 'content-type: application/json' \
-H 'postman-token: c9108a7a-402b-9879-0a51-310a8e1d1e79' \
-d '{
    "name":"SJC Pluviometer Station",
    "code":"JR2019"
}'
```

##### NODE Unirest

```js
var unirest = require("unirest");

var req = unirest("POST", "http://localhost:8090/api/v1/instrument");

req.headers({
"postman-token": "0e6621d4-e455-4400-4230-035a7f3acc10",
"cache-control": "no-cache",
"content-type": "application/json"
});

req.type("json");
req.send({
"name": "SJC Pluviometer Station",
"code": "JR2019"
});

req.end(function (res) {
if (res.error) throw new Error(res.error);

console.log(res.body);
});
```

##### JAVA Unirest

```java
HttpResponse<String> response = Unirest.post("http://localhost:8090/api/v1/instrument")
.header("content-type", "application/json")
.header("cache-control", "no-cache")
.header("postman-token", "f3ad9ac4-2fb0-9cc3-8075-d2724ce2ddd5")
.body("{\n\t\"name\":\"SJC Pluviometer Station\",\n\t\"code\":\"JR2019\"\n}")
.asString();
```

### Acquisitions

The `acquisition` endpoint serialize the arrived object and post into a acquisition Queue and the consumer consume this object and save into database.

```json
{
	"value": 0.12,
	"instrument": {
		"id": "5c4f1a50c4060226a6e93c92"
	}
}
```

##### JS

```js
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8090/api/v1/acquisition",
  "method": "POST",
  "headers": {
    "content-type": "application/json",
    "cache-control": "no-cache",    
  },
  "processData": false,
  "data": "{\n\t\"value\": 0.12,\n\t\"instrument\": {\n\t\t\"id\": \"5c4f1a50c4060226a6e93c92\"\n\t}\n}\n"
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
```

##### CURL

```sh
curl -X POST \
  http://localhost:8090/api/v1/acquisition \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: a639058b-2efc-0e4d-fd56-4bd1e73f2042' \
  -d '{
	"value": 0.12,
	"instrument": {
		"id": "5c4f1a50c4060226a6e93c92"
	}
}
'
```

##### NODE Unirest

```js
var unirest = require("unirest");

var req = unirest("POST", "http://localhost:8090/api/v1/acquisition");

req.headers({  
  "cache-control": "no-cache",
  "content-type": "application/json"
});

req.type("json");
req.send({
  "value": 0.12,
  "instrument": {
    "id": "5c4f1a50c4060226a6e93c92"
  }
});

req.end(function (res) {
  if (res.error) throw new Error(res.error);

  console.log(res.body);
});
```

##### JAVA Unirest

```java
HttpResponse<String> response = Unirest.post("http://localhost:8090/api/v1/acquisition")
  .header("content-type", "application/json")
  .header("cache-control", "no-cache")  
  .body("{\n\t\"value\": 0.12,\n\t\"instrument\": {\n\t\t\"id\": \"5c4f1a50c4060226a6e93c92\"\n\t}\n}\n")
  .asString();
```

`GET`

### Instruments

```js
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8090/api/v1/instrument/all",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache",    
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
```

```java
HttpResponse<String> response = Unirest.get("http://localhost:8090/api/v1/instrument/all")
  .header("cache-control", "no-cache")  
  .asString();
```

```json
[
    {
        "id": "5c4f1a50c4060226a6e93c92",
        "name": "SJC Pluviometer Station",
        "code": "JR2019",
        "created": "2019-01-28 13:05:52"
    }
]
```

### Acquisitions

```js
var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8090/api/v1/acquisition/all",
  "method": "GET",
  "headers": {
    "cache-control": "no-cache",
  }
}

$.ajax(settings).done(function (response) {
  console.log(response);
});
```

```java
HttpResponse<String> response = Unirest.get("http://localhost:8090/api/v1/acquisition/all")
  .header("cache-control", "no-cache")  
  .asString();
```

```json
[
    {
        "id": "5c4f26f0c4060226a6e93c9c",
        "value": 0.12,
        "created": "2019-01-28 13:59:44",
        "instrument": {
            "id": "5c4f1a50c4060226a6e93c92",
            "name": "SJC Pluviometer Station",
            "code": "JR2019",
            "created": "2019-01-28 13:05:52"
        }
    },
    {
        "id": "5c4f270bc4060226a6e93c9d",
        "value": 0.12,
        "created": "2019-01-28 14:00:11",
        "instrument": {
            "id": "5c4f1a50c4060226a6e93c92",
            "name": "SJC Pluviometer Station",
            "code": "JR2019",
            "created": "2019-01-28 13:05:52"
        }
    }
]
```