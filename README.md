# GreekStemmer

A simple Greek stemmer algorithm.

This algorithm is based on this [paper](http://people.dsv.su.se/~hercules/papers/Ntais_greek_stemmer_thesis_final.pdf) from George Ntais.

## Install (lein)

```clojure
[greek_stemmer "0.0.1"]
```

## Usage

```clojure
  (use 'greek_stemmer.core)

  (greek_stemmer.core/stem "ΚΙΘΑΡΙΣΤΑΣ")
  ;; "ΚΙΘΑΡΙΣΤ"
```

## References

* [Development of a Stemmer for the Greek Language](http://people.dsv.su.se/~hercules/papers/Ntais_greek_stemmer_thesis_final.pdf)

## Credits

Original work: [bandito](https://github.com/bandito)

## Contributing

1. Fork it ( http://github.com/<my-github-username>/greek_stemmer/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.

## License

Distributed under the Eclipse Public License, the same as Clojure.