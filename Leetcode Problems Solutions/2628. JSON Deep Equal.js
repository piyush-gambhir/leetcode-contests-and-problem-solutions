/*
Problem Link: https://leetcode.com/problems/json-deep-equal/
*/

/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
  if (typeof o1 !== typeof o2) {
    return false;
  }

  if (typeof o1 === "object" && o1 !== null && o2 !== null) {
    const isArray1 = Array.isArray(o1);
    const isArray2 = Array.isArray(o2);

    if (isArray1 !== isArray2) {
      return false;
    }

    if (isArray1 && isArray2) {
      if (o1.length !== o2.length) {
        return false;
      }

      for (let i = 0; i < o1.length; i++) {
        if (!areDeeplyEqual(o1[i], o2[i])) {
          return false;
        }
      }

      return true;
    }

    const keys1 = Object.keys(o1);
    const keys2 = Object.keys(o2);
    if (keys1.length !== keys2.length) {
      return false;
    }

    for (let key of keys1) {
      if (!areDeeplyEqual(o1[key], o2[key])) {
        return false;
      }
    }

    return true;
  }

  return o1 === o2;
};
