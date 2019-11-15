local tmp = redis.call("set", KEYS[1], ARGV[1])
return tmp