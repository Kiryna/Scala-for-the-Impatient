_Look at the BitSet class, and make a diagram of all its superclasses and traits. Ignore the type parameters (everything inside the_ `[...]`_). Then give the linearization of the traits._

BitSet extends SortedSet with BitSetLike
 
lin(BitSet)
 
 = BitSet >> lin(BitSetLike) >> lin(SortedSet)
 
 = BitSet >> (BitSetLike >> ~~lin(SortedSetLike)~~) >> (SortedSet >> lin(SortedSetLike) >> lin(Set))
 
 = BitSet >> BitSetLike >> SortedSet >> (SortedSetLike >> ~~lin(SetLike)~~ >> lin(Sorted)) >> (Set >> lin(SetLike) >> lin (GenericSetTemplate) >> lin(GenSet) >> lin(Iterable) >> lin(Function1))
 
 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> (Sorted >> ~~lin(AnyRef)~~) >> Set >> (SetLike >> lin(Parallelizable) >> lin(Subtractable) >> 
  ~~lin(GenSetLike)~~ >> ~~lin(IterableLike)~~) >> ~~(GenericSetTemplate >> lin(GenericTraversableTemplate))~~ >> (GenSet >> lin(GenericSetTemplate) >> ~~lin(GenIterable)~~ >>
  lin(GenSetLike)) >> (Iterable >> lin(IterableLike) >> lin(GenericTraversableTemplate) >> lin(GenIterable) >> lin(Traversable)) >> (Function1 >> lin(AnyRef))
 
 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set >> SetLike >> ~~(Parallelizable >> lin(Any))~~ >> (Subtractable >> ~~lin(AnyRef)~~) >> GenSet >>
  (GenericSetTemplate >> ~~lin(GenericTraversableTemplate)~~) >> (GenSetLike >> lin(Parallelizable) >> ~~lin(Equals)~~ >> ~~lin(Function1)~~ >> ~~lin(GenIterableLike)~~) >> 
  Iterable >> (IterableLike >> ~~lin(GenIterableLike)~~ >> ~~lin(TraversableLike)~~ >> lin(Equals)) >> ~~(GenericTraversableTemplate >> lin(HasNewBuilder))~~ >> 
  (GenIterable >> ~~lin(GenericTraversableTemplate)~~ >> ~~lin(GenTraversable)~~ >> lin(GenIterableLike)) >> (Traversable >> lin(GenericTraversableTemplate) >> lin(TraversableOnce) >>
  lin(GenTraversable) >> lin(TraversableLike)) >> Function1 >> (AnyRef >> lin(Any)) 

 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set >> SetLike >> Subtractable >> GenSet >> GenericSetTemplate >> GenSetLike >> (~~Parallelizable ~~>> ~~lin(Any)~~) >>
  Iterable >> IterableLike >> (Equals >> ~~lin(Any)~~) >> GenIterable >> (GenIterableLike >> ~~lin(TraversableLike)~~) >> Traversable >> ~~(GenericTraversableTemplate >> lin(HasNewBuilder))~~>>
  (~~TraversableOnce~~ >> ~~lin(GenTraversableOnce)~~) >> (GenTraversable >> lin(GenericTraversableTemplate) >> lin(GenTraversableOnce) >> ~~lin(GenTraversableLike)~~) >> (TraversableLike >> 
  lin(Parallelizable) >> lin(GenTraversableLike) >> lin(TraversableOnce) >> lin(FilterMonadic) >> lin(HasNewBuilder)) >> Function1 >> AnyRef >> Any 
  
 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set >> SetLike >> Subtractable >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> Equals >> 
   GenIterable >> GenIterableLike >> Traversable >> GenTraversable >> (GenericTraversableTemplate >> ~~lin(HasNewBuilder)~~) >> ~~(GenTraversableOnce >> lin(Any))~~ >> TraversableLike >>
   ~~(Parallelizable >> lin(Any))~~ >> (GenTraversableLike >> lin(Parallelizable) >> ~~lin(GenTraversableOnce)~~) >> (TraversableOnce >> lin(GenTraversableOnce)) >> (FilterMonadic >> ~~lin(AnyRef)~~) >>
   (HasNewBuilder >> ~~lin(AnyRef)~~) >> Function1 >> AnyRef >> Any
  
 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set >> SetLike >> Subtractable >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> Equals >> 
   GenIterable >> GenIterableLike >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> GenTraversableLike >> (Parallelizable >> ~~lin(Any)~~) >> TraversableOnce >> 
   (GenTraversableOnce >> ~~lin(Any)~~) >> FilterMonadic >> HasNewBuilder >> Function1 >> AnyRef >> Any
   
 = BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Sorted >> Set >> SetLike >> Subtractable >> GenSet >> GenericSetTemplate >> GenSetLike >> Iterable >> IterableLike >> Equals >> 
   GenIterable >> GenIterableLike >> Traversable >> GenTraversable >> GenericTraversableTemplate >> TraversableLike >> GenTraversableLike >> Parallelizable >> TraversableOnce >> 
   GenTraversableOnce >> FilterMonadic >> HasNewBuilder >> Function1 >> AnyRef >> Any