/*
Problem Link: https://leetcode.com/problems/promise-time-limit/
*/

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
  return async function (...args) {
    const promise = fn(...args);
    const timeout = new Promise((resolve, reject) => {
      setTimeout(() => reject("Time Limit Exceeded"), t);
    });
    return Promise.race([promise, timeout]); // Return a promise that resolves or rejects based on which promise resolves or rejects first
  };
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
