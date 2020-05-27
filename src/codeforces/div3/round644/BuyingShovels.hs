import Control.Monad (replicateM_)

getDivisors n limit = [x | x <- [1 .. limit], n `mod` x == 0]

getShovelType :: [Int] -> Int
getShovelType [n, k] =
    if length beforeSqrt == 0 then head afterSqrt
    else head beforeSqrt
    where
        limit = (round . sqrt . fromIntegral) n
        divisors = getDivisors n limit
        beforeSqrt = filter (\x -> n `div` x <= k) divisors
        afterSqrt = filter (\x -> n `div` x <= k) ((reverse . map (\x -> n `div` x)) divisors)

readLine :: IO [Int]
readLine = (map read) . words <$> getLine

main =
    read <$> getLine >>= \t ->
    replicateM_ t (getShovelType <$> readLine >>= print)