{-# LANGUAGE StandaloneDeriving #-}

module Main where

import Test.HUnit
import Test.Framework as TF (defaultMain, testGroup, Test)
import Test.Framework.Providers.HUnit (testCase)
-- import Test.Framework.Providers.QuickCheck2 (testProperty)

import LCA

main = defaultMain tests -- runs the tests

tests :: [TF.Test]
tests = [ testGroup "\nTutorial 03 Tests\n"
            [ insertTests
           ]
        ]

myTree :: Tree Int
myTree = Node 1 
    (Node 2 
        (Node 4 Empty Empty)
        (Node 5 Empty Empty))
    (Node 3 
        (Node 6 Empty Empty)
        (Node 7 Empty Empty))

insertTests :: TF.Test
insertTests
 = testGroup "\nPart 1 - Insertions\n"
    [ testCase "Insert into empty" (lca_show myTree 4 5  @?= 2)
    ]



