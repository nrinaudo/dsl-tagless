# Introduction

Good afternoon everybody, I'm Nicolas Rinaudo and I work for a swedish company called Besedo where we do a lot of online content moderation and machine learning. This has given me ample opportunity to mess up in creative ways, which in turn allowed me to build a long list of how not to do things, and a much shorter one of how to actually do them.

And today I'm here because I'd like to talk to you about one of these few, useful things that I've learned through through trial but mostly error: DSLs - or, really, EDSLs: domain specific languages that are written in, and interpreted by, the host language.

I want to talk about them for two reasons.

First, they're useful, powerful and definitely something that more people should be using.

Second, the various encodings we have for them are interesting and a good way of learning concepts that will prove useful to solve a variety of other problems.

Today, I intend to focus on two common encodings: GADTs and Tagless Final.

The promise of this talk is that, by the end of it, you will understand both approaches, what are their tradeoffs, and when you should prefer one over the other.
Along the way, you'll also learn useful techniques for solving the most common problems people face when writing DSLs.

What you will not learn is why Tagless Final is called that way, because nobody seems to know.

The scenario I'll be using to illustrate DSLs is taken directly from my day job and is mostly, but not entirely, fictional.

# Conclusion

If you only remember one slide, this is the one: the slide in which I point that I delivered on my promise.

I told you you'd understand what GADTs and Tagless Final encodings are, and how they differ, and you do:
- GADTs are data with clever types. They're easy to work with, but hard to extend.
- Tagless Final is functions. It's overall harder to work with, but easy to extend.

I also promised you'd understand when you should prefer one over the other, and you do: prefer GADTs unless you need to compose DSLs. So, really, just use GADTs.

And finally, you were promised we'd see common problems when dealing with DSLs, and how to solve them, and we did: evaluation, pretty printing, rewriting and serialisation.

# Don't forget

It can be hard to follow Tagless Final if it's not explicitly pointed out that a `Symantic[Something]` is really just a way of turning a value of the DSL into `Something`.
