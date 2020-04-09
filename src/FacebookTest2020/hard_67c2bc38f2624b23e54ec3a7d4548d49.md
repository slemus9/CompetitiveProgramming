# Hash, Hash, Hashtag - Hard

## Summary
In this problem your job is to identify the most popular hashtags
appearing in a set of posts. The input will consist of a list of posts with
their respective timestamp. Each post will be expressed in 2 lines of input -
the first line will consist of a timestamp of the post - an integer from [0,
1440) identifying the minute of the day in which the post appeared online
followed by a line that will consist of the post's content - a space-delimited
line of text. A hashtag is defined as any token which begins with a # after an
empty space.

## Problem
Considering trending hashtags are only computed in the last 60
minutes, find the hashtag that was the most popular in its 60 minute window
(This means, the hashtag that was mentioned in the highest amount of posts in 60
consecutive minutes).

### Example 1

#### Input
```
80
This #post has hashtag #b 5 times, #b #b #b #b

0
This is a #post

60
This #post has hashtags #a #b and #c

220
This is for the time #window

200
This #post again has hashtag #b 3 times #b #b but happens in a time #window

210
This #post is for the time #window

220
This is for the time #window

240
Now in this time #window people like talking about windows

20
This is another #post where I say how #happy I am
```

#### Output

In the example input, *#window* is the hashtag that appears in most posts in 60
consecutive minutes. This is, if we take the posts from the instant *200 until
260*, *#window* appears 5 times in this timeframe. While *#post* still appears
on more posts overall, they are more spaced in time and it doesn't appear more
than 2 times in a 60 minute period (instant *0 until 60*).

```
#window
```
