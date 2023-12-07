/*
Problem Link: https://leetcode.com/problems/curry/

/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function (fn) {
  return function curried() {
    var args = Array.prototype.slice.call(arguments);
    if (args.length >= fn.length) {
      return fn.apply(null, args);
    } else {
      return function () {
        var args2 = Array.prototype.slice.call(arguments);
        return curried.apply(null, args.concat(args2));
      };
    }
  };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
