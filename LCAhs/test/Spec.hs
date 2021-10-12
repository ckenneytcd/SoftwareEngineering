{-# LANGUAGE StandaloneDeriving #-}

module Main where

import Test.HUnit
import Test.Framework as TF (defaultMain, testGroup, Test)
import Test.Framework.Providers.HUnit (testCase)

import LCA

main = defaultMain tests -- runs the tests

tests :: [TF.Test]
tests = [ testGroup "\nTutorial 03 Tests\n"
            [ insertTests
           ]
        ]

--     1
--   /    \
--  2      3
-- / \    / \
--4   5  6   7

insertTests :: TF.Test
insertTests
 = testGroup "\nPart 1 - Insertions\n"
    [ testCase "Does not exisit: LCA of 0 and 9" ((lca_show LCA.myTree 0 9)  @?= "not found")
    , testCase "Does not exisit: LCA of 0 and 5" ((lca_show LCA.myTree 0 5)  @?= "not found")
    , testCase "LCA of 4 and 5" ((lca_show LCA.myTree 4 5)  @?= "2")
    , testCase "LCA of 4 and 6" ((lca_show LCA.myTree 4 6)  @?= "1")
    , testCase "LCA of 3 and 4" ((lca_show LCA.myTree 3 4)  @?= "1")
    , testCase "LCA of 2 and 4" ((lca_show LCA.myTree 2 4)  @?= "2")
    , testCase "LCA of 2 and 3" ((lca_show LCA.myTree 2 3)  @?= "1")
    ]
