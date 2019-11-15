local tmp = redis.call("get", KEYS[1]);
return tmp