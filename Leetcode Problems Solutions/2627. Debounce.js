/*
Problem Link: https://leetcode.com/problems/debounce/
*/

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var debounce = function (fn, t) {
  let timeoutId;

  return function (...args) {
    clearTimeout(timeoutId);

    timeoutId = setTimeout(() => {
      fn.apply(this, args);
    }, t);
  };
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
