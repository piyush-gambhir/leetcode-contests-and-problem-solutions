/*
Prolem Link: https://leetcode.com/problems/cache-with-time-limit/
*/

var TimeLimitedCache = function () {
  this.cache = {};
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
  var currentTime = Date.now();
  var expirationTime = currentTime + duration;

  if (this.cache[key] && this.cache[key].expirationTime > currentTime) {
    this.cache[key].value = value;
    this.cache[key].expirationTime = expirationTime;
    return true;
  }

  this.cache[key] = {
    value: value,
    expirationTime: expirationTime,
  };

  return false;
};

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
  var currentTime = Date.now();

  if (this.cache[key] && this.cache[key].expirationTime > currentTime) {
    return this.cache[key].value;
  }

  return -1;
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
  var currentTime = Date.now();
  var count = 0;

  for (var key in this.cache) {
    if (this.cache[key].expirationTime > currentTime) {
      count++;
    }
  }

  return count;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */
