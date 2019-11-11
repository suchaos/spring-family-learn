### 操作过程记录

```shell script
docker pull mongo

# 注意，在 windows 加 -v 会报错（结果是这样）
docker run --name mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo

# 登录到 MongoDB 容器器中
docker exec -it mongo bash

# 通过 Shell 连接 MongoDB
mongo -u admin -p admin

> show dbs;

> use springbucks;
switched to db springbucks
> db.createUser(
 {
   user: "springbucks",
   pwd: "springbucks",
   roles: [ {role: "readWrite", db: "springbucks"}]
 }
)

show users;
```

```shell script
> use springbucks;
switched to db springbucks
> show collections;
coffee
> db.coffee.find();
{ "_id" : ObjectId("5dc6ba0eabb490a0406f34a2"), "name" : "espresso", "price" : { "money" : { "currency" : { "code" : "CNY", "numericCode" : 156, "decimalPlaces" : 2 }, "amount" : "20.00" } }, "createTime" : ISODate("2019-11-09T13:07:26.974Z"), "updateTime" : ISODate("2019-11-09T13:07:26.974Z"), "_class" : "com.suchaos.mongo.model.Coffee" }
```

```shell script
> db.coffee.remove({"name": "espresso"});
WriteResult({ "nRemoved" : 1 })
```