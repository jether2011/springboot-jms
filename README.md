# Springboot - JMS
Springboot JMS

# App URL

Access at: `https://jms-jr.herokuapp.com/`

# Endpoints

Resources (examples to use and test): 
1. `POST`

### JS

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

### CURL

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

### NODE Unirest

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

### JAVA Unirest

```java
HttpResponse<String> response = Unirest.post("http://localhost:8090/api/v1/instrument")
.header("content-type", "application/json")
.header("cache-control", "no-cache")
.header("postman-token", "f3ad9ac4-2fb0-9cc3-8075-d2724ce2ddd5")
.body("{\n\t\"name\":\"SJC Pluviometer Station\",\n\t\"code\":\"JR2019\"\n}")
.asString();
```