# Talk Abstract

DSLs are extremely powerful - well used, they let developers outsource their work to non-technical domain experts, while still pretending they’re working.

Unfortunately, they’re easy to get wrong. This talk means to show the most common pitfalls, and how to avoid them.

# Talk Description

Working with domain experts can be frustrating for all parties involved - it’s very hard for them to get the subtle nuances of their craft across, and aggravating for developers to constantly tweak and refine code to reflect ever evolving specifications.

There is, fortunately, a solution: Domain Specific Languages, small, highly specialised languages that allow experts to write exactly what they mean, without needing to involve developers for each new tweak.

These DSLs can be a lot of fun to use and write, but are also easy to get wrong. The purpose of this talk is to walk through a slightly simplified version of a language currently used in production to process millions of documents, show the most common problems that need to be solved, and offer reasonable, easy to understand solutions.

At the end of the talk, attendants will have a solid understanding of how to design their own DSLs, and of the strengths of weaknesses of their standard encoding.

# Misc.

This talk attempts to achieve a variety of goals.

First, it must be accessible to non-experts. It does involve a few complicated concepts (GADTs, natural recursion, …), but in such a way that I feel even beginners will have no trouble following. I have over the years developed a presentation style that lets attendants focus on the important parts of code samples and ignore the “noise”, and feel confident that even people that know close to 0 Scala will be able to follow without a problem.

Second, now that Scala 3 is out, it’s intended to show off a variety of features - enums, of course, as well as the new brace-free syntax and union types. But, depending on how tight I manage to make it, there will also be more exotic features, such as polymorphic functions, context functions, type lambdas, givens, extension methods, multiversal equality…

One reason I feel relatively confident in giving this talk is that it’s mostly a slightly embellished retelling of actual events, problems and solutions my team worked on recently. The DSL we’ll build is a simplified version of an actual language used very successfully in production today to handle millions of documents per day.
