--
-- @lc app=leetcode.cn id=175 lang=mysql
--
-- [175] 组合两个表
--

-- @lc code=start
# Write your MySQL query statement below
SELECT
    p.firstName, 
    p.lastName,
    a.city,
    a.state
FROM Person AS p
LEFT JOIN Address AS a
ON p.personId = a.personId;
-- @lc code=end

