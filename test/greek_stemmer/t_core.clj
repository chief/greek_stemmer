(ns greek_stemmer.t-core
  (:use midje.sweet)
  (:use [greek_stemmer.core]))

(fact "it does not stem non Greek words"
  (stem "english")   => "english"
  (stem "με-παύλα")  => "με-παύλα"
  (stem "ελληνικά-with-english") => "ελληνικά-with-english")

(fact "it does not stem very small words (<= 2)"
  (stem "αν") => "αν"
  (stem "ζω") => "ζω")

(fact "it treats step 1 correctly"
  (stem "ΚΡΕΑΣ")      => "ΚΡΕ"
  (stem "ΠΑΝΓΚΡΕΑΣ")  => "ΠΑΝΓΚΡΕ"
  (stem "ΗΜΙΦΩΣ")     => "ΗΜΙΦΩ"
  (stem "ΚΟΜΠΟΛΟΓΙΑ") => "ΚΟΜΠΟΛΟ"
  (stem "ΠΑΤΕΡΑΣ")    => "ΠΑΤΕΡ")

(fact "it treats step 2a correctly"
  (stem "ΓΙΑΓΙΑΔΩΝ") => "ΓΙΑΓΙ"
  (stem "ΟΜΑΔΕΣ")    => "ΟΜΑΔ")

(fact "it treats step 2b correctly"
  (stem "ΚΑΦΕΔΩΝ") => "ΚΑΦ"
  (stem "ΓΗΠΕΔΩΝ") => "ΓΗΠΕΔ")

(fact "it treats step 2c correctly"
  (stem "ΠΑΠΠΟΥΔΩΝ") => "ΠΑΠΠ"
  (stem "ΑΡΚΟΥΔΕΣ")  => "ΑΡΚΟΥΔ")

(fact "it treats step 2d correctly"
  (stem "ΥΠΟΘΕΣΕΩΣ") => "ΥΠΟΘΕΣ"
  (stem "ΥΠΟΘΕΣΕΩΝ") => "ΥΠΟΘΕΣ"
  (stem "ΘΕΩΝ")      => "ΘΕ")

(fact "it treats step 3 correctly"
  (stem "ΠΑΙΔΙΑ")  => "ΠΑΙΔ"
  (stem "ΤΕΛΕΙΟΥ") => "ΤΕΛΕΙ"
  (stem "ΤΕΛΕΙΩΝ") => "ΤΕΛΕΙ")

(fact "it treats step 4 correctly"
  (stem "ΖΗΛΙΑΡΙΚΟ") => "ΖΗΛΙΑΡ"
  (stem "ΑΓΡΟΙΚΟΥ")  => "ΑΓΡΟΙΚ")

(fact "it treats step 5a correctly"
  (stem "ΑΓΑΠΑΜΕ")    => "ΑΓΑΠ"
  (stem "ΑΓΑΠΗΣΑΜΕ")  => "ΑΓΑΠ"
  (stem "ΑΝΑΠΑΜΕ")    => "ΑΝΑΠΑΜ")

(fact "it treats step 5b correctly"
  (stem "ΑΓΑΠΗΣΑΝΕ")    => "ΑΓΑΠ"
  (stem "ΤΡΑΓΑΝΕ")      => "ΤΡΑΓΑΝ"
  (stem "ΒΡΑΧΜΑΝΕ")     => "ΒΡΑΧΜΑΝ"
  (stem "ΣΑΡΑΚΑΤΣΑΝΕ")  => "ΣΑΡΑΚΑΤΣΑΝ")

(fact "it treats step 5c correctly"
  (stem "ΑΓΑΠΗΣΕΤΕ")  => "ΑΓΑΠ"
  (stem "ΒΕΝΕΤΕ")     => "ΒΕΝΕΤ")

(fact "it treats step 5d correctly"
  (stem "ΑΓΑΠΩΝΤΑΣ")  => "ΑΓΑΠ"
  (stem "ΑΡΧΟΝΤΑΣ")   => "ΑΡΧΟΝΤ"
  (stem "ΚΡΕΩΝΤΑΣ")   => "ΚΡΕΩΝΤ")

(fact "it treats step 5e correctly"
  (stem "ΑΓΑΠΙΟΜΑΣΤΕ") => "ΑΓΑΠ"
  (stem "ΟΝΟΜΑΣΤΕ")    => "ΟΝΟΜΑΣΤ")

(fact "it treats step 5f correctly"
  (stem "ΑΓΑΠΙΕΣΤΕ")  => "ΑΓΑΠ"
  (stem "ΠΙΕΣΤΕ")     => "ΠΙΕΣΤ"
  (stem "ΕΚΤΕΛΕΣΤΕ")  => "ΕΚΤΕΛΕΣΤ")

(fact "it treats step 5g correctly"
  (stem "ΧΤΙΣΤΗΚΕ")     => "ΧΤΙΣΤ"
  (stem "ΔΙΑΘΗΚΕΣ")     => "ΔΙΑΘΗΚ"
  (stem "ΚΑΤΑΚΤΗΘΗΚΕ")  =>  "ΚΑΤΑΚΤ"
  (stem "ΠΟΛΕΜΗΘΗΚΕ")   => "ΠΟΛΕΜ")

(fact "it treats step 5h correctly"
  (stem "ΧΤΥΠΟΥΣΕΣ")  => "ΧΤΥΠ"
  (stem "ΜΕΔΟΥΣΑ")    => "ΜΕΔΟΥΣ"
  (stem "ΜΕΔΟΥΣΕΣ")   => "ΜΕΔΟΥΣ")

(fact "it treats step 5i correctly"
  (stem "ΚΟΛΛΑΓΕΣ") => "ΚΟΛΛ"
  (stem "ΑΒΑΣΤΑΓΑ") => "ΑΒΑΣΤΑΓ")

(fact "it treats step 5j correctly"
  (stem "ΑΓΑΠΗΣΕ")  => "ΑΓΑΠ"
  (stem "ΝΗΣΟΥ")    => "ΝΗΣ")

(fact "it treats step 5k correctly"
  (stem "ΑΓΑΠΗΣΤΕ") => "ΑΓΑΠ"
  (stem "ΣΒΗΣΤΕ")   => "ΣΒΗΣΤ")

(fact "it treats step 5l correctly"
  (stem "ΑΓΑΠΟΥΝΕ") => "ΑΓΑΠ"
  (stem "ΝΟΥΝΕ")    => "ΝΟΥΝ")

(fact "it treats step 5m correctly"
  (stem "ΑΓΑΠΟΥΜΕ") => "ΑΓΑΠ"
  (stem "ΦΟΥΜΕ")    => "ΦΟΥΜ")

(fact "it treats step 6a correctly"
  (stem "ΚΥΜΑΤΑ") => "ΚΥΜ")

(fact "it treats post-process step correctly"
  (stem "ΑΓΑΠΩ")    => "ΑΓΑΠ"
  (stem "ΚΥΜΑ")   => "ΚΥΜ"
  (stem "ΦΟΥΜΟΣ")   => "ΦΟΥΜ"
  (stem "ΧΩΡΑΤΑ") => "ΧΩΡΑΤ"
  (stem "ΧΩΡΑΤΟ") => "ΧΩΡΑΤ"
  (stem "ΔΙΑΘΗΚΗ")      => "ΔΙΑΘΗΚ"
  (stem "ΣΒΗΣΤΟΣ")  => "ΣΒΗΣΤ"
  (stem "ΚΟΛΛΑΩ")   => "ΚΟΛΛ"
  (stem "ΑΒΑΣΤΑΓΟ") => "ΑΒΑΣΤΑΓ"
  (stem "ΝΗΣΟΣ")    => "ΝΗΣ"
  (stem "ΧΤΥΠΩ")      => "ΧΤΥΠ"
  (stem "ΝΟΥΝΟΣ")   => "ΝΟΥΝ")

(fact "it treats step 7 correctly"
  (stem "ΠΛΗΣΙΕΣΤΑΤΟΣ") => "ΠΛΗΣΙ"
  (stem "ΜΕΓΑΛΥΤΕΡΗ") => "ΜΕΓΑΛ"
  (stem "ΚΟΝΤΟΤΕΡΟ") => "ΚΟΝΤ")
