--
-- @lc app=leetcode.cn id=176 lang=mysql
--
-- [176] 第二高的薪水
--

-- @lc code=start
# Write your MySQL query statement below
-- 使用窗口函数
-- SELECT IF (salary IS NOT NULL, salary, NULL) AS SecondHighestSalary
-- FROM (
--     SELECT
--         *,
--         ROW_NUMBER() OVER (ORDER BY salary) AS rn
--     FROM employee
-- ) AS employee_list
-- WHERE rn = 2
-- ;

SELECT DISTINCT salary AS SecondHighestSalary
FROM employee
ORDER BY salary
LIMIT 1, 1
;

-- @lc code=end

