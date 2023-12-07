/*
Problem Link: https://leetcode.com/problems/find-the-celebrity/
*/

/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Function}
 */
var promisePool = async function (promises, n) {
  const results = [];

  async function evaluateNextPromise() {
    if (promises.length === 0) return;

    const currentPromise = promises.shift();
    const result = await currentPromise();

    results.push(result);

    await evaluateNextPromise();
  }

  const nPromises = Array(n).fill().map(evaluateNextPromise);
  await Promise.all(nPromises);

  return [results, results[results.length - 1]];
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
