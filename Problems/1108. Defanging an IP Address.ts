/*
Problem Link: https://leetcode.com/problems/defanging-an-ip-address/
*/

function defangIPaddr(address: string): string {
  return address.split(".").join("[.]");
}
