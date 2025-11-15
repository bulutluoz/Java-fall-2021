package interviewprep.behavioral;

/**
 * BEHAVIORAL INTERVIEW QUESTIONS - FAANG & TOP TECH COMPANIES
 *
 * Use the STAR Method for all behavioral questions:
 * - Situation: Set the context
 * - Task: Describe your responsibility
 * - Action: Explain what YOU did
 * - Result: Share the outcome (quantify if possible)
 *
 * Preparation Tips:
 * 1. Prepare 5-7 strong stories that can answer multiple questions
 * 2. Quantify results whenever possible (improved performance by X%, reduced time by Y hours)
 * 3. Show growth mindset and learning from failures
 * 4. Be honest - interviewers can detect fabricated stories
 */
public class BehavioralQuestions {

    /**
     * ===== LEADERSHIP & INFLUENCE =====
     */

    // Q1: Tell me about a time you led a team through a difficult project
    public static final String LEADERSHIP_DIFFICULT_PROJECT = """
            STAR Example:
            Situation: During my bootcamp capstone project, our team of 5 was building an e-commerce platform
                       with only 3 weeks remaining when our tech lead dropped out.

            Task: I volunteered to step up as the new tech lead while maintaining my development responsibilities.

            Action:
            - Reorganized sprint structure into daily standups and pair programming sessions
            - Created a detailed task breakdown and assigned based on each member's strengths
            - Implemented code review process to maintain quality
            - Stayed late to help struggling team members debug issues

            Result: Delivered the project on time with all core features working. Our demo received the
                    highest score in the cohort. Three team members mentioned my leadership in their
                    LinkedIn recommendations.
            """;

    // Q2: Describe a time you had to influence others without direct authority
    public static final String INFLUENCE_WITHOUT_AUTHORITY = """
            STAR Example:
            Situation: In a previous project, I noticed our team was duplicating code across multiple modules,
                       increasing bugs and maintenance time.

            Task: Convince the team to refactor and create a shared utilities library, despite not being
                  the technical lead.

            Action:
            - Created a proof-of-concept showing 40% reduction in code duplication
            - Prepared metrics showing increased bug count in duplicated code areas
            - Presented findings in team meeting with concrete examples
            - Volunteered to lead the refactoring effort and mentor others

            Result: Team agreed to adopt the approach. Refactoring reduced codebase by 1,200 lines,
                    decreased bug reports by 35% in those modules over next 2 months.
            """;

    /**
     * ===== CONFLICT & DISAGREEMENT =====
     */

    // Q3: Tell me about a time you disagreed with a coworker/manager
    public static final String DISAGREEMENT_WITH_COLLEAGUE = """
            STAR Example:
            Situation: During API design review, my senior colleague insisted on using REST for all endpoints,
                       but I believed GraphQL would be better for our specific use case with complex nested data.

            Task: Present my perspective professionally without undermining the senior developer's experience.

            Action:
            - Scheduled 1-on-1 meeting to discuss rather than arguing in team meeting
            - Created comparison document with pros/cons for our specific requirements
            - Built a small prototype demonstrating GraphQL reducing API calls by 60%
            - Acknowledged benefits of REST and suggested hybrid approach

            Result: We adopted a hybrid solution - GraphQL for the complex data queries and REST for
                    simple CRUD operations. This became our team's standard pattern. Senior developer
                    appreciated the data-driven approach and we collaborated well afterward.
            """;

    // Q4: Describe a situation where you had to work with a difficult team member
    public static final String DIFFICULT_TEAM_MEMBER = """
            STAR Example:
            Situation: Paired with a team member who was very defensive about code reviews and would
                       argue about every suggestion, slowing down our development velocity.

            Task: Improve the working relationship while maintaining code quality standards.

            Action:
            - Shifted approach to ask questions rather than make statements ("What do you think about..."
              instead of "You should...")
            - Started highlighting positive aspects of their code first
            - Had coffee chat to understand their perspective - learned they had bad experience with
              harsh criticism at previous job
            - Proposed pair programming for complex features to build trust

            Result: Relationship improved significantly. Code review discussions became collaborative.
                    Team member later thanked me for the patient approach and became one of our most
                    receptive developers for feedback.
            """;

    /**
     * ===== FAILURE & LEARNING =====
     */

    // Q5: Tell me about a time you failed
    public static final String TIME_YOU_FAILED = """
            STAR Example:
            Situation: In my first major project, I was responsible for implementing a new authentication
                       system. I was confident I could complete it in 1 week.

            Task: Design and implement JWT-based authentication with refresh tokens.

            Action:
            - Dove straight into coding without proper research or design
            - Didn't ask for help when I got stuck on refresh token rotation
            - Underestimated security considerations and edge cases

            Result: Missed deadline by 4 days and had to be helped by senior developer to fix security
                    vulnerabilities I created.

            LEARNING:
            - Now I always start with research and design doc before coding
            - Break tasks into smaller chunks with buffer time
            - Ask for help early when stuck (2-hour rule)
            - Had senior developer review the auth implementation and learned proper security patterns
            - Used this experience to create a security checklist our team now uses
            """;

    // Q6: Describe a time you made a mistake that impacted others
    public static final String MISTAKE_IMPACTED_OTHERS = """
            STAR Example:
            Situation: Deployed code to production without running full test suite (only unit tests,
                       skipped integration tests due to time pressure).

            Task: Quick deployment of a small feature addition before the weekend.

            Action:
            - Merged and deployed based on unit test success
            - Feature went live Friday evening

            Result: Broke the payment flow for 2 hours on Saturday before I noticed monitoring alerts.
                    Had to emergency rollback and fix. Impacted approximately 50 customers.

            LEARNING:
            - Implemented mandatory CI/CD pipeline that blocks deployment without full test pass
            - Created runbook for emergency rollback procedures
            - Set up better monitoring and alerting
            - Never skip testing steps regardless of time pressure
            - Had retrospective with team and we established "no Friday deployments" rule for
              major changes
            """;

    /**
     * ===== PROBLEM SOLVING & INNOVATION =====
     */

    // Q7: Tell me about a time you solved a complex technical problem
    public static final String COMPLEX_TECHNICAL_PROBLEM = """
            STAR Example:
            Situation: Application performance degraded significantly as data grew. Page load times
                       increased from 200ms to 8+ seconds, causing user complaints.

            Task: Identify bottleneck and improve performance to acceptable levels (<500ms).

            Action:
            - Profiled application using JProfiler to identify bottleneck
            - Found N+1 query problem in ORM - loading user + all posts + all comments separately
            - Researched solutions: eager loading, batch fetching, caching
            - Implemented combination approach:
              * Added query optimization with JOIN fetching
              * Implemented Redis cache for frequently accessed data
              * Added database indexes on foreign keys
            - Load tested before deployment

            Result: Reduced page load from 8s to 180ms (96% improvement). User satisfaction scores
                    increased from 6.2 to 8.7. Applied same patterns to other slow endpoints.
            """;

    // Q8: Describe an innovative solution you implemented
    public static final String INNOVATIVE_SOLUTION = """
            STAR Example:
            Situation: Team spent 30+ hours per month manually testing API endpoints after each deployment.
                       This was error-prone and delayed releases.

            Task: Find a way to reduce manual testing effort while improving reliability.

            Action:
            - Proposed contract testing approach using consumer-driven contracts
            - Built automated test suite that ran on every commit
            - Created integration with CI/CD pipeline
            - Documented the process and trained team members
            - Set up Slack notifications for test failures

            Result: Reduced manual testing time by 85% (from 30 hours to ~4 hours per month).
                    Caught 12 breaking changes before production in first 3 months.
                    Other teams adopted the approach. I presented it at company tech talk.
            """;

    /**
     * ===== DEADLINES & PRESSURE =====
     */

    // Q9: Tell me about a time you had to meet a tight deadline
    public static final String TIGHT_DEADLINE = """
            STAR Example:
            Situation: Client requested critical bug fix that was blocking their product launch.
                       Normal timeline would be 1 week, but they needed it in 2 days.

            Task: Fix the bug and deploy to production within 48 hours.

            Action:
            - Immediately triaged to understand scope and impact
            - Declined new meeting requests and blocked my calendar
            - Broke problem into smaller parts and prioritized critical path
            - Coordinated with QA to parallelize testing
            - Kept stakeholders updated every 6 hours
            - Worked extended hours but maintained code quality standards

            Result: Delivered fix in 40 hours with comprehensive testing. Client's launch proceeded
                    on schedule. They became our company's largest account that year. Received
                    employee recognition award for the effort.
            """;

    // Q10: Describe a time you had to balance multiple competing priorities
    public static final String COMPETING_PRIORITIES = """
            STAR Example:
            Situation: Working on major feature when critical production bug emerged, while also committed
                       to mentoring a junior developer and presenting at team meeting - all in same week.

            Task: Handle all responsibilities without dropping the ball on any.

            Action:
            - Assessed urgency and impact of each item
            - Delegated feature work's non-critical parts to teammate
            - Fixed production bug first (2 hours)
            - Rescheduled mentoring session but sent junior developer learning resources
            - Prepared presentation in incremental chunks during breaks
            - Communicated clearly with all stakeholders about adjusted timelines

            Result: Bug fixed within SLA, feature delivered on time with team help, mentoring session
                    happened with better prep, presentation was well-received. Learned to proactively
                    communicate when priorities shift.
            """;

    /**
     * ===== COLLABORATION & TEAMWORK =====
     */

    // Q11: Tell me about a time you helped a struggling team member
    public static final String HELPED_STRUGGLING_MEMBER = """
            STAR Example:
            Situation: Junior developer on our team was struggling with understanding async/await patterns
                       in JavaScript, causing delays in their tasks and growing frustration.

            Task: Help them understand the concept without making them feel inadequate.

            Action:
            - Scheduled optional pairing sessions (didn't want to seem forced)
            - Created visual diagrams explaining call stack, event loop, callback queue
            - Built simple examples progressing from callbacks to promises to async/await
            - Reviewed their code with encouraging feedback
            - Shared resources that helped me learn the concept

            Result: Within 2 weeks, they were confidently using async patterns. Their velocity improved
                    by 40%. They later told manager that my mentorship was crucial to their growth.
                    We still pair program regularly.
            """;

    // Q12: Describe a successful team project you contributed to
    public static final String SUCCESSFUL_TEAM_PROJECT = """
            STAR Example:
            Situation: Team tasked with building real-time chat feature for our application, which was
                       new territory for all of us.

            Task: Implement WebSocket-based chat with message history, typing indicators, and read receipts.

            Action:
            - Volunteered to research WebSocket libraries (chose Socket.io)
            - Created spike solution and presented findings to team
            - Took ownership of backend WebSocket server
            - Collaborated with frontend developer on event contracts
            - Implemented comprehensive error handling and reconnection logic
            - Created deployment runbook and monitoring dashboards

            Result: Launched feature successfully with 99.8% uptime in first month. User engagement
                    increased by 45%. Feature became a key differentiator in sales demos. Our
                    implementation became the reference for other teams building real-time features.
            """;

    /**
     * ===== RECEIVING & GIVING FEEDBACK =====
     */

    // Q13: Tell me about a time you received constructive criticism
    public static final String RECEIVED_CRITICISM = """
            STAR Example:
            Situation: Manager provided feedback that my code reviews were too focused on style/formatting
                       and missing bigger architectural issues.

            Task: Improve code review quality to focus on what matters most.

            Action:
            - Asked for specific examples to understand the pattern
            - Studied architectural review guides and best practices
            - Created personal checklist: Security > Architecture > Logic > Style
            - Started reviewing with "big picture" first, details second
            - Sought feedback from manager on my next few reviews

            Result: Code reviews became more valuable to team. Caught 3 significant architectural issues
                    in next month. Team members said my reviews were more insightful. Manager noted
                    the improvement in next 1-on-1.
            """;

    // Q14: Describe a time you had to give difficult feedback
    public static final String GAVE_DIFFICULT_FEEDBACK = """
            STAR Example:
            Situation: Colleague consistently came late to standup meetings (15-30 minutes), disrupting
                       the team's flow and requiring us to repeat updates.

            Task: Address the issue without damaging the relationship.

            Action:
            - Waited for private moment rather than calling out publicly
            - Used "I" statements: "I've noticed you've been late to standups, and I'm concerned..."
            - Asked if there were circumstances I didn't know about (was genuinely curious)
            - Explained impact: team waiting, repeating information, losing momentum
            - Listened to their perspective (timezone confusion with home office schedule)
            - Worked together on solution

            Result: They started setting earlier alarms and was on time for 90% of meetings afterward.
                    They appreciated the private, respectful approach. Our working relationship
                    remained strong.
            """;

    /**
     * ===== AMAZON LEADERSHIP PRINCIPLES SPECIFIC =====
     */

    // Q15: Customer Obsession - Tell me about a time you went above and beyond for a customer
    public static final String CUSTOMER_OBSESSION = """
            STAR Example:
            Situation: Customer reported that export feature was missing data they needed for their
                       quarterly report due next day.

            Task: Find a solution despite the feature not being designed for that use case.

            Action:
            - Investigated to understand their exact needs
            - Realized our current export didn't include archived data
            - Created custom SQL query to extract the specific data they needed
            - Validated data accuracy with customer
            - Documented the use case for product team
            - Followed up to ensure their report went well

            Result: Customer submitted report successfully. They later became our reference customer
                    for sales. Product team added the feature to roadmap based on my documentation.
            """;

    // Q16: Bias for Action - Tell me about a calculated risk you took
    public static final String BIAS_FOR_ACTION = """
            STAR Example:
            Situation: Team was debating for 2 weeks which database to use for new microservice
                       (PostgreSQL vs MongoDB). Analysis paralysis was delaying project.

            Task: Move the project forward without perfect information.

            Action:
            - Proposed time-boxed experiment: build same feature in both (3 days each)
            - Defined success criteria: performance, ease of development, operational overhead
            - Built both implementations and ran benchmarks
            - Presented objective comparison to team

            Result: Data clearly showed PostgreSQL met our needs better. Team made decision immediately.
                    Saved 2+ weeks of debate. Delivered project ahead of schedule. Approach was adopted
                    for future technical decisions.
            """;

    // Q17: Dive Deep - Tell me about a time you had to dive deep to solve a problem
    public static final String DIVE_DEEP = """
            STAR Example:
            Situation: Intermittent bug in production - happened once per week, couldn't reproduce locally,
                       no clear pattern in logs.

            Task: Find root cause of elusive bug despite limited information.

            Action:
            - Enhanced logging in suspected areas (without impacting performance)
            - Deployed to production with detailed trace logging
            - Monitored logs for 2 weeks, collected 3 instances of the bug
            - Noticed pattern: all occurred during specific time window (2-3 AM)
            - Investigated what was different at that time (found scheduled cleanup job)
            - Discovered race condition between cleanup job and user requests
            - Reproduced locally by simulating the timing

            Result: Fixed the race condition with proper locking. Bug hasn't recurred in 6 months.
                    Created monitoring alert for similar race conditions. Shared findings in tech
                    talk to help team avoid similar issues.
            """;

    /**
     * ===== WHY THIS COMPANY / ROLE =====
     */

    // Q18: Why do you want to work here?
    public static final String WHY_THIS_COMPANY = """
            Framework for answering:

            1. SPECIFIC COMPANY ASPECTS (research required):
               - Technology stack alignment with your interests
               - Company's impact on industry/society
               - Engineering culture (from Glassdoor, blog posts, tech talks)
               - Specific products/projects that excite you

            2. GROWTH OPPORTUNITIES:
               - Technical challenges you'll face
               - Learning from talented engineers
               - Scale of systems you'll work on

            3. VALUE ALIGNMENT:
               - Company values that resonate with you
               - Mission that you care about

            Example (for a company like Google):
            "I'm excited about Google for three main reasons. First, the scale of systems - working on
            products used by billions allows me to have real impact while solving fascinating technical
            challenges. Second, I'm passionate about your approach to engineering excellence, like
            having 20% time for innovation and strong code review culture. I've read several papers
            from Google Research that influenced my own work. Third, I'm particularly interested in
            your work on [specific product], and I believe my experience with [relevant skills] would
            let me contribute immediately while learning from world-class engineers."

            Make it specific. Generic answers are red flags.
            """;

    // Q19: Why are you leaving your current role?
    public static final String WHY_LEAVING = """
            Framework (stay positive!):

            GOOD REASONS:
            - Seeking new technical challenges
            - Want to work at different scale
            - Interested in different domain/industry
            - Seeking stronger engineering culture
            - Want to learn new technologies
            - Company doesn't have growth path in your area of interest

            AVOID:
            - Badmouthing current employer
            - Focusing on compensation only
            - Complaining about people
            - Blaming others for your decision

            Example:
            "I've learned a tremendous amount at my current company and appreciate the opportunities
            I've had there. However, I'm at a point where I want to work on larger-scale distributed
            systems, which your company excels at. My current role is more focused on internal tools
            for a smaller user base, and I'm ready to tackle the challenges that come with building
            for millions of users. I'm also excited about your team's use of Go and Kubernetes, which
            align with where I want to develop my expertise."
            """;

    /**
     * ===== ADDITIONAL COMMON QUESTIONS =====
     */

    // Q20: Tell me about yourself
    public static final String TELL_ME_ABOUT_YOURSELF = """
            Structure (keep to 60-90 seconds):

            1. PRESENT (20 seconds):
               - Current role and key responsibilities
               - Notable recent achievement

            2. PAST (20 seconds):
               - How you got into tech/this field
               - Relevant experience or education

            3. FUTURE (20 seconds):
               - Why you're interested in this role
               - What you're excited to work on

            Example:
            "I'm currently a Java developer at XYZ Company, where I focus on building microservices
            for our e-commerce platform. Recently, I led the migration of our monolith to microservices,
            which improved our deployment frequency by 300%.

            I got into programming during my bootcamp at ABC in 2021, where I fell in love with
            problem-solving and building scalable systems. Since then, I've specialized in backend
            development with Java and Spring Boot.

            I'm excited about this opportunity because I want to work on distributed systems at a
            larger scale, and your company's work on [specific product] aligns perfectly with my
            interests in high-performance systems and my experience with Java and cloud technologies."
            """;

    /**
     * QUESTIONS TO ASK THE INTERVIEWER
     * (Always prepare 3-5 good questions)
     */
    public static final String QUESTIONS_FOR_INTERVIEWER = """
            ABOUT THE ROLE:
            - What does a typical day look like for someone in this role?
            - What are the biggest challenges I would face in the first 3-6 months?
            - How do you measure success for this position?
            - What's the team structure, and who would I be working most closely with?

            ABOUT THE TEAM:
            - Can you tell me about the team's current projects?
            - How does the team handle technical disagreements?
            - What's the on-call rotation like?
            - How does the team approach code reviews and testing?

            ABOUT ENGINEERING CULTURE:
            - How do you balance new feature development with technical debt?
            - What's your approach to professional development and learning?
            - How are architectural decisions made?
            - What does the deployment process look like?

            ABOUT GROWTH:
            - What opportunities are there for learning and growth?
            - How does the company support career development?
            - What does the career ladder look like for this role?

            ABOUT THE COMPANY:
            - What are the company's goals for the next year?
            - How has the team evolved over the past year?
            - What do you enjoy most about working here?

            AVOID:
            - Questions answered on company website
            - Compensation/benefits (save for later rounds)
            - "What does your company do?" (do your research!)
            - Work-life balance in first interview (can seem like red flag)
            """;
}
