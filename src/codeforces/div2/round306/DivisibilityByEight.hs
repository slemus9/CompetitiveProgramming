contained :: String -> String -> Bool
contained [] s = True
contained pat [] = null pat
contained pat@(x : xs) (y : ys)
    | x == y = contained xs ys
    | otherwise = contained pat ys

findNum :: String -> String
findNum s = ans where
    nums = filter (`contained` s) (map show [0, 8..992])
    ans = if null nums then "" else head nums

main =
    findNum <$> getLine >>= \ans ->
    if null ans then putStrLn "NO"
    else putStrLn ("YES\n" ++ ans)