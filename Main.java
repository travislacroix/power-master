// Agent based model of actors playing complimentary coordiantion problem
// (Nash bargaining game)
// Include string memory with best responses to the string,
// As in Axtell, et al. (2001) Emergence of classes model.
// Include disagreement point as analogue for power.

import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    // Create parameters to store variable population sizes, memories, and disagrement points
    // These should be changed manually

    // Size of each subpopulation, A and B
    int[] populationMaster = {5, 10, 25, 50};

    // Length of memory for each agent
    int[] memoryMaster = {5, 10, 15, 20};

    // Disagrement point for power analogue
    double[] disagreementMaster = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5};

    // This loop iterates through each population size in master above
    for (int pp=0; pp < populationMaster.length; pp++) {

      // Set population size for this game and print for output records
      int agentNum = populationMaster[pp];
      System.out.println("\n" + "***** POPULATION SIZE IS " + numAgents + " *****");

      // This loop iterates each game through the various disagrement points in master above
      for (int mm=0; mm < memoryMaster.length; mm++) {

        // Define length of memory string for agents in populations A and B and print
        int memoryLengthA = memoryMaster[mm];
        int memoryLengthB = memoryMaster[mm];
        System.out.println("\n" + "***** Memory length for population A is " + memoryLengthA + " *****");
        System.out.println("***** Memory length for population B is " + memoryLengthB + " *****");

        // This loop iterates each game through the disagreement points in master above
        for (int dd=0; dd < disagreement.length; dd++) {

          // Define disagreement point for this game, and print for records
          double d = disagreement[dd];
          System.out.println("\n" + "Disagreement point is " + d);

          // We are now ready to initialize the variables to play a round of our game

          // Payoffs for matrices below. F = fail, L = low, M = mid, H = high
          // These may be altered manually
          // LL and HH are for more fine-grained payoffs.
          int F = 0;
          int LL = 2;
          int L = 4;
          int M = 5;
          int H = 6;
          int HH = 8;

          // Initialize variables for holding strategies
          int aStrat = 0;
          int bStrat = 0;

          // define number of runs (xx) and number of plays per run (xxx)
          int xx = 1000;
          int xxx;

          // Larger populations require more iterations for convergence
          // The numbers here are sufficient for populationMaster = {5,10,25,50}
          if (pp == 0) {
            xxx = 10000;
          } else if (pp == 1) {
            xxx = 35000;
          } else if (pp == 2) {
            xxx = 3000000;
          } else if (pp == 3) {
            xxx = 50000000;
          }

          // Define number of possible strategies; we start with 3.
          // NOTE if this is updated (e.g., to 5), payoff matrices must be updated manually below
          int stratNum = 3;

          // Define buffer for calculating convergence results.
          int buffer = 0;

          // Create payoff matrices for popA, popB, and Power (disagrement)
          // Matrices vary depending upon stratNum
          double[] payoffA;
          double[] payoffB;
          double[] payoffD;

          if (stratNum == 2) {
            payoffA = {{L,L},{H,F}};
            payoffB = {{L,L},{H,F}};
            payoffD = {{L,L},{H,d}};
          } else if (stratNum == 3) {
            payoffA = {{L,L,L},{M,M,F},{H,F,F}};
            payoffB = {{L,L,L},{M,M,F},{H,F,F}};
            payoffD = {{L,L,L},{M,M,d},{H,d,d}};
          } else if (stratNum == 5) {
            payoffA = {{LL,LL,LL,LL,LL},{L,L,L,L,F},{M,M,M,F,F},{H,H,F,F,F},{HH,F,F,F,F}};
            payoffB = {{LL,LL,LL,LL,LL},{L,L,L,L,F},{M,M,M,F,F},{H,H,F,F,F},{HH,F,F,F,F}};
            payoffD = {{LL,LL,LL,LL,LL},{L,L,L,L,d},{M,M,M,d,d},{H,H,d,d,d},{HH,d,d,d,d}};
          }

          // Matrix to hold outcomes
          // outputs a vector for each strategy plus a non-convergence counter.
          int[] outcomes;
          outcomes = new int[stratNum + 1];

          // Initialize matrices to record, for each agent, their current strategy
          // Population A:
          int[] agentStratA = new int[agentNum];
          for (int j=0; j < agentNum; j++) {
              agentStratA[j] = 3;
          }
          // Population B:
          int[] agentStratB = new int[agentNum];
          for (int j=0; j < agentNum; j++) {
              agentStratB[j] = 3;
          }




        } // End for-loop iterating through disagreementMaster
      } // End for-loop iterating through memoryMaster
    } // End for-loop iterating through populationMaster

  } // End public static void main()
} // end class Main


//         // Begin number of runs, xx
//         for (int ii=0; ii<xx; ii++) {
//             // Begin by initializing agents for this run, and fill memories randomly
//             // Memories are to be updated as gameplay proceeds
//
//             // Intitialize agents; Track memory for each agent
//             int[][] agentsA;
//             agentsA = new int[agentNum][memoryLengthA];
//
//             int[][] agentsB;
//             agentsB = new int[agentNum][memoryLengthB];
//
//             int specialPlayer = 0;
//
//             // Initialize memories for this run, populate memory randomly with {0,...,stratNum}.
//             for (int i=0; i<agentNum; i++) {
//                 for (int j=0; j<memoryLengthA; j++) {
//                     /*agentsA[i][j] = (int)(Math.random()*stratNum);*/
//                     agentsA[i][j] = 20;
//                 }
//             }
//
//             for (int i=0; i<agentNum; i++) {
//                 for (int j=0; j<memoryLengthB; j++) {
//                     /*agentsB[i][j] = (int)(Math.random()*stratNum);*/
//                     agentsB[i][j] = 20;
//                 }
//             }
//
//             // Begin individual trials per run, given by xxx
//             for (int iii=0; iii<xxx; iii++) {
//                 //System.out.println("\n" + "We are currently playing trial " + iii + " of round " + ii + "\n");
//
//                 // Begin by randomly choosing two partners, one from A and one from B:
//                 int a = (int)(Math.random()*agentNum);
//                 int b = (int)(Math.random()*agentNum);
//                 //System.out.println("Agent A on round " + iii + " is " + a);
//                 //System.out.println("Agent B on round " + iii + " is " + b);
//
//                 double[] payHistory;
//
//                 // Determine which strategies actors will play
//
//                 // Player A:
//                 // Determine which strategies the actors will play in the general case
//                 payHistory = new double[stratNum];
//                 //System.out.println("Starting PayHistory for A is given by " + Arrays.toString(payHistory));
//                 // Note: This is a more robust implementation than having manual entries, aa bb cc, etc.
//                 // I believe it still does what we want it to do though.
//
//                 //Begin by updating our strategy array (strategy given by index) for total payoffs historically for each strategy
//                 for (int i=0; i<payHistory.length; i++) {
//                     for (int j=0; j<memoryLengthA; j++) {
//                         if (agentsA[a][j] == 20) {
//                             // Do nothing
//                         } else {
//                             payHistory[i] = payHistory[i] + payoffA[i][agentsA[a][j]];
//                         }
//                     }
//                 }
//
//                 //System.out.println("PayHistory for player A-" + a + " for this round is given by " + Arrays.toString(payHistory));
//
//                 // The following bit of code tells us whether there is a duplicate of the max payoff (maxCount > 1);
//                 // If so, there is no unique best response
//                 double max = 0;
//                 double maxCount = 0;
//
//                 for (double x : payHistory) {
//                     if (x > max) {
//                         max = x;
//                         maxCount = 1;
//                     } else if (x == max) {
//                         maxCount++;
//                     }
//                 }
//
//                 // Pick best response, if there is a unique one; otherwise randomize
//                 if (maxCount == 1) {
//                     for (int i=0; i<payHistory.length; i++) {
//                         aStrat = payHistory[i] > payHistory[aStrat] ? i : aStrat;
//                     }
//                 } else {
//                     aStrat = (int)(Math.random()*stratNum);
//                 }
//
//                 // Record current strategy of agent A
//                 agentStratA[a] = aStrat;
//
//                 // Uncomment to display player strategy for each trial of each round.
//                 /*
//                 System.out.println("Game " + ii + ": On Trial " + iii + " aStrat for player " + a + " is " + aStrat);
//                 */
//
//                 // Player B:
//
//                 // Reset pertinent values
//                 payHistory = new double[stratNum];
//                 //System.out.println("Starting PayHistory for B is given by " + Arrays.toString(payHistory));
//                 max = 0;
//                 maxCount = 0;
//
//                 if (b == 0) {
//                     specialPlayer += 1;
//                     // Update strategy array based on histories
//                     for (int i=0; i<payHistory.length; i++) {
//                         for (int j=0; j<memoryLengthB; j++) {
//                             if (agentsB[b][j] == 20) {
//                                 // Do nothing
//                             } else {
//                                 payHistory[i] = payHistory[i] + payoffD[i][agentsB[b][j]];
//                             }
//                         }
//                     }
//                     //System.out.println("PayHistory for player B-" + b + " for this round is given by " + Arrays.toString(payHistory));
//
//                     // The following bit of code tells us whether there is a duplicate of the max payoff (maxCount > 1);
//                     // If so, there is no unique best response
//                     for (double x : payHistory) {
//                         if (x > max) {
//                             max = x;
//                             maxCount = 1;
//                         } else if (x == max) {
//                             maxCount++;
//                         }
//                     }
//
//                     // Pick best response, if there is a unique one; otherwise randomize
//                     if (maxCount == 1) {
//                         for (int i=0; i<payHistory.length; i++) {
//                             bStrat = payHistory[i] > payHistory[bStrat] ? i : bStrat;
//                         }
//                     } else {
//                         bStrat = (int)(Math.random()*stratNum);
//                     }
//                 } else {
//                     // Update strategy array based on histories
//                     for (int i=0; i<payHistory.length; i++) {
//                         for (int j=0; j<memoryLengthB; j++) {
//                             if (agentsB[b][j] == 20) {
//                                 // Do nothing
//                             } else {
//                                 payHistory[i] = payHistory[i] + payoffB[i][agentsB[b][j]];
//                             }
//                         }
//                     }
//                     //System.out.println("PayHistory for player B-" + b + " for this round is given by " + Arrays.toString(payHistory));
//
//                     // The following bit of code tells us whether there is a duplicate of the max payoff (maxCount > 1);
//                     // If so, there is no unique best response
//                     for (double x : payHistory) {
//                         if (x > max) {
//                             max = x;
//                             maxCount = 1;
//                         } else if (x == max) {
//                             maxCount++;
//                         }
//                     }
//
//                     // Pick best response, if there is a unique one; otherwise randomize
//                     if (maxCount == 1) {
//                         for (int i=0; i<payHistory.length; i++) {
//                             bStrat = payHistory[i] > payHistory[bStrat] ? i : bStrat;
//                         }
//                     } else {
//                         bStrat = (int)(Math.random()*stratNum);
//                     }
//                 }
//
//                 // Record current strategy for agent B
//                 agentStratB[b] = bStrat;
//
//                 // Uncomment to display player strategy for each Round
//                 /*
//                 System.out.println("Game " + ii + ": On Trial " + iii + " bStrat for player " + b + " is " + bStrat);
//                 */
//
//                 // Update the memories of both Actors
//                 // Shift all the memory slots to the left, then record opponent strategy in final entry
//
//                 // Player A
//                 for (int i=0; i<memoryLengthA-1; i++) {
//                     agentsA[a][i] = agentsA[a][i+1];
//                 }
//                 agentsA[a][memoryLengthA-1] = bStrat;
//
//                 //Player B
//                 for (int i=0; i<memoryLengthB-1; i++) {
//                     agentsB[b][i] = agentsB[b][i+1];
//                 }
//                 agentsB[b][memoryLengthB-1] = aStrat;
//
//                 // End Run
//             }
//
//             // Uncomment to print memory for each agent at the end of each run
//             /*
//             System.out.println("\n" + "Round " + ii + ":" + "\n");
//             System.out.println("A-Agents");
//             for (int i=0; i<agentNum; i++) {
//                 System.out.print("Agent A-" + i + " memory: " + Arrays.toString(agentsA[i]) + "\n");
//             }
//             System.out.println("\n" + "B-Agents");
//             for (int i=0; i<agentNum; i++) {
//                 System.out.print("Agent B-" + i + " memory: " + Arrays.toString(agentsB[i]) + "\n");
//             }
//             */
//             // The following displays the strategy number for each population, which gives some measure of evenness
//             // Min is 0; Max is 2*(agentNum)*(agentMemory)
//             double endA = 0;
//             double endB = 0;
//
//             for (int i=0; i<agentNum; i++) {
//                 for (int j=0; j<memoryLengthA; j++) {
//                     endA = endA + agentsA[i][j];
//                     //System.out.println("EndA is given by: " + endA);
//                 }
//             }
//
//             for (int i=0; i<agentNum; i++) {
//                 for (int j=0; j<memoryLengthB; j++) {
//                     endB = endB + agentsB[i][j];
//                     //System.out.println("EndB is given by: " + endB);
//                 }
//             }
//
//             //System.out.println("EndA is given by " + endA);
//             //System.out.println("EndB is given by " + endB);
//
//             if (endA >= 2*agentNum*memoryLengthA-buffer) {
//                 outcomes[0] = outcomes[0] + 1;
//             } else if (endB >= 2*agentNum*memoryLengthB-buffer) {
//                 outcomes[1] = outcomes[1] + 1;
//             } else if (endA == agentNum*memoryLengthA && endB == agentNum*memoryLengthB) {
//                 outcomes[2] = outcomes[2] + 1;
//             } else {
//                 outcomes[3] = outcomes[3] + 1;
//             }
//
//             // System.out.println("\n" + "In round " + ii + " Agent B-0 was called upon " + specialPlayer + " times out of a possible " + xxx);
//
//             //End of Game
//         }
//
//         // PRINT RESULTS:
//         System.out.println();
//         System.out.println("A Plays Low " + outcomes[0] + " times");
//         System.out.println("B Plays Low " + outcomes[1] + " times");
//         System.out.println("Fair play " + outcomes[2] + " times");
//         System.out.println("Did not converge " + outcomes[3] + " times");
//         }
//         }
//     }
// }
