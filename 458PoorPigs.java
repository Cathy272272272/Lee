https://leetcode.com/problems/poor-pigs/discuss/94273/solution-with-detailed-explanation
    To be honest, I've spent several days thinking about this question. It's not only fun, but also confusing. it drives me up the wall, especially for its easy difficulty. ?

Thinking Process
1. What if you only have one shot?

Eg. 4 buckets, 15 mins to die, and 15 mins to test.

The answer is 2. Suppose we use A and B to represent pigs, we could have

0_1478958363340_upload-5c96756b-ca9f-41f2-b597-ff57a040ebe8

Obviously we could use the binary form to represent the solution.

0_1478958322597_upload-0812d848-8375-4422-813e-b97bdd37c653

Conclusion: If we have x pigs, we could use them to represent (encode) 2^x buckets.

2. What if we could have more than one attempts?

Eg. 4 buckets, 15 mins to die, and 30 mins to test.

At the moment, I consider the problem as an encoding problem: With more attempts, how to use fewer pigs to represent all the buckets?

I got lost at this step by keep thinking the binary way. After hanging around the forum, I got the idea to change my views. Let's go back to the one shot situation. What does the binary form mean? It's much easier if we regard it as:

0 means the pig does not drink and die.
1 means the pig drinks in the first (and only) round.
We could generalise with:

0 means the pig does not drink and die.
1 means the pig drinks in the first round and die.
2 means the pig drinks in the second round and die.
...
t means the pig drinks in the t-th round and die.
Conclusion: If we have t attempts, we could use t+1-based number to represent (encode) the buckets. (That's also why the first conclusion uses the 2-based number)

Example
Eg. 8 buckets, 15 mins to die, and 40 mins to test.

We have 2 (= (40/15).floor) attempts, as a result we'll use 3-based number to encode the buckets.

How many pigs do we need? Answer is 2 (= Math.log(8, 3).ceil)

0_1478960257723_upload-0da5c126-bf43-4183-935d-c2c1a5b5df15

For example 3-based number 02 means: the pig A does not drink and die, and the pig B drinks in the second round and die.
                                                                                                         
class 458PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }
}