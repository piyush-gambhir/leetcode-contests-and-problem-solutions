/*
Problem Link: https://leetcode.com/problems/check-if-object-instance-of-class/
*/

/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function (obj, classFunction) {
  try {
    if (obj === null || obj === undefined) {
      return false;
    }
    if (obj instanceof classFunction) {
      return true;
    }

    var prototype = Object.getPrototypeOf(obj);
    while (prototype !== null) {
      if (prototype === classFunction.prototype) {
        return true;
      }
      prototype = Object.getPrototypeOf(proto);
    }

    return false;
  } catch (e) {
    return false;
  }
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
