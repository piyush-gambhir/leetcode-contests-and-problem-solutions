/*
Problem Link: https://leetcode.com/problems/add-two-promises/
*/

type P = Promise<number>;

async function addTwoPromises(promise1: P, promise2: P): P {
  const [a, b] = await Promise.all([promise1, promise2]);
  return Promise.resolve(a + b);
}

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */
