package hackerrank.senior.java.backend.developer.test;

/**
 *  HackerRank Link: https://www.hackerrank.com/contests/hackerrank-senior-java-backend-developer-test/challenges/interviews/
 * */


public class Interviews_DB_Query {


}
/*

    select con.contest_id, con.hacker_id, con.name,
        sum(ss.total_submissions) as total_submissions, sum(ss.total_accepted_submissions) as total_accepted_submissions,
        sum(vs.total_views) as total_views, sum(vs.total_unique_views) as total_unique_views
        from Contests con
        inner join Colleges col on col.contest_id = con.contest_id
        inner join Challenges ch on ch.college_id = col.college_id
        left join (select challenge_id, sum(total_views) as total_views, sum(total_unique_views) as total_unique_views
        from view_stats group by challenge_id) vs on ch.challenge_id = vs.challenge_id
        left join (select challenge_id, sum(total_submissions) as total_submissions, sum(total_accepted_submissions) as total_accepted_submissions
        from submission_stats group by challenge_id) ss on ch.challenge_id = ss.challenge_id
        group by con.contest_id, con.hacker_id, con.name
        having (sum(ss.total_submissions) > 0 and sum(ss.total_accepted_submissions) > 0 and sum(vs.total_views)>0 and sum(vs.total_unique_views)>0)
        order by con.contest_id asc

*/