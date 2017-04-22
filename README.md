# ptf
Performance testing framework that measure API calls and have replaceable parts as reporting, statistics collector, measured tool, flow config and test runner. All tests are considered to be JUnit tests that could be run quickly.  
## Modules:
1. ptf-core - core of Performance Testing Framework
2. ptf-properties - implementation of core parts using properties file
    1. Test flow configuration
    2. Runners configuration
    3. Context Configuration
3. ptf-spring - implementation of core parts using spring context:
    1. Defining test flow in spring xml file
    2. Configure components via spring xml file

Look more about each module in their README.md files

## Components
1. Test
2. Suite
3. MeasurementService
4. Measurement
5. Runners:
    1. SuiteRunner
    2. TestRunner
    3. TestFlowRunner
6. Context:
    1. FlowContext
    2. TestContext
    3. ThreadContext
7. ID/Name - <SuiteID, TestID, RunID> triple is unique identification of one run:
    1. SuiteId (ex. suite1)
    2. TestId (ex. 'CreateUser') - includes list of
    3. RunId (ex. 'iteration', 'thread', ...)
8. Barrier - synchronized threads (configurable)
9. ExecutionService - thread execution service.

## Test execution
One test could be executed N times in K threads. Each execution is synchronized with other threads, so each iteration executes K same calls at one time (at one time means, as it possible to do in java API).

### Test API
Each Test should extend **AbstractTest** that configured with JUnit runner API so it could be run directly from IDE.  

#### TestFlowRunner calls each **Test** in the next order:  
1. test.init(threadContext)
2. test.before()
3. test.test() - N times
4. test.after()
5. threadContext.getMeasurements()

## Next objects are created per thread:   
1. Test
2. ThreadContext
3. TestFlowRunner
4. MeasurementService
5. Measurement

## Next objects are created per test:
1. TestContext
2. TestRunner

## Next objects are created per suite:
1. SuiteRunner
2. Suite
3. SuiteContext
