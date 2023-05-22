/*
Problem Link: https://leetcode.com/problems/convert-object-to-json-string/
*/

/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function (object) {
  let jsonString = JSON.stringify(object);
  return jsonString;
};
