import qualified Data.Set as S

getChunksSizes :: String -> S.Set Char -> [Int]
getChunksSizes xs set = go xs 0 where
    go [] acc = [acc]
    go (x : xs) acc = 
        if S.member x set then acc : go xs 0
        else go xs (acc + 1)

summation :: Int -> Integer
summation n = x*(x + 1) `div` 2 where
    x = toInteger n

getNumSubs :: String -> S.Set Char -> Integer
getNumSubs xs keys = foldl (+) 0 $ map summation (getChunksSizes xs keys)

getMissingKeys :: String -> String ->  S.Set Char
getMissingKeys xs keys = S.difference setXs setKeys where
    setXs = S.fromList xs
    setKeys = S.fromList keys

main =
    getLine >> getLine >>= \xs ->
    concat . words <$> getLine >>= \keys ->
    print $ getNumSubs xs (getMissingKeys xs keys)