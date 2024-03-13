2. Fold commands
fold-commands E490
All folding commands start with "z".  Hint: the "z" looks like a folded piece
of paper, if you look at it from the side.
CREATING AND DELETING FOLDS
							zf E350
zf{motion}  or
{Visual}zf	Operator to create a fold.
		This only works when 'foldmethod' is "manual" or "marker".
		The new fold will be closed for the "manual" method.
		'foldenable' will be set.
		Also see fold-create-marker.
							zF
zF		Create a fold for [count] lines.  Works like "zf".
:{range}fo[ld]						:fold :fo
		Create a fold for the lines in {range}.  Works like "zf".
							zd E351
zd		Delete one fold at the cursor.  When the cursor is on a folded
		line, that fold is deleted.  Nested folds are moved one level
		up.  In Visual mode one level of all folds (partially) in the
		selected area are deleted.
		Careful: This easily deletes more folds than you expect and
		there is no undo for manual folding.
		This only works when 'foldmethod' is "manual" or "marker".
		Also see fold-delete-marker.
							zD
zD		Delete folds recursively at the cursor.  In Visual mode all
		folds (partially) in the selected area and all nested folds in
		them are deleted.
		This only works when 'foldmethod' is "manual" or "marker".
		Also see fold-delete-marker.
							zE E352
zE		Eliminate all folds in the window.
		This only works when 'foldmethod' is "manual" or "marker".
		Also see fold-delete-marker.
OPENING AND CLOSING FOLDS
A fold smaller than 'foldminlines' will always be displayed like it was open.
Therefore the commands below may work differently on small folds.
							zo
zo		Open one fold under the cursor.  When a count is given, that
		many folds deep will be opened.  In Visual mode one level of
		folds is opened for all lines in the selected area.
							zO
zO		Open all folds under the cursor recursively.  Folds that don't
		contain the cursor line are unchanged.
		In Visual mode it opens all folds that are in the selected
		area, also those that are only partly selected.
							zc
zc		Close one fold under the cursor.  When a count is given, that
		many folds deep are closed.  In Visual mode one level of folds
		is closed for all lines in the selected area.
		'foldenable' will be set.
							zC
zC		Close all folds under the cursor recursively.  Folds that
		don't contain the cursor line are unchanged.
		In Visual mode it closes all folds that are in the selected
		area, also those that are only partly selected.
		'foldenable' will be set.
							za
za		Summary: Toggle the fold under the cursor.
		When on a closed fold: open it.  When folds are nested, you
		may have to use "za" several times.  When a count is given,
		that many closed folds are opened.
		When on an open fold: close it and set 'foldenable'.  This
		will only close one level, since using "za" again will open
		the fold.  When a count is given that many folds will be
		closed (that's not the same as repeating "za" that many
		times).
							zA
zA		When on a closed fold: open it recursively.
		When on an open fold: close it recursively and set
		'foldenable'.
							zv
zv		View cursor line: Open just enough folds to make the line in
		which the cursor is located not folded.
							zx
zx		Update folds: Undo manually opened and closed folds: re-apply
		'foldlevel', then do "zv": View cursor line.
		Also forces recomputing folds.  This is useful when using
		'foldexpr' and the buffer is changed in a way that results in
		folds not to be updated properly.
							zX
zX		Undo manually opened and closed folds: re-apply 'foldlevel'.
		Also forces recomputing folds, like zx.
							zm
zm		Fold more: Subtract v:count1 from 'foldlevel'.  If 'foldlevel' was
		already zero nothing happens.
		'foldenable' will be set.
							zM
zM		Close all folds: set 'foldlevel' to 0.
		'foldenable' will be set.
							zr
zr		Reduce folding: Add v:count1 to 'foldlevel'.
							zR
zR		Open all folds.  This sets 'foldlevel' to highest fold level.
							:foldo :foldopen
:{range}foldo[pen][!]
		Open folds in {range}.  When [!] is added all folds are
		opened.  Useful to see all the text in {range}.  Without [!]
		one level of folds is opened.
							:foldc :foldclose
:{range}foldc[lose][!]
		Close folds in {range}.  When [!] is added all folds are
		closed.  Useful to hide all the text in {range}.  Without [!]
		one level of folds is closed.
							zn
zn		Fold none: reset 'foldenable'.  All folds will be open.
							zN
zN		Fold normal: set 'foldenable'.  All folds will be as they
		were before.
							zi
zi		Invert 'foldenable'.
MOVING OVER FOLDS
							[z
[z		Move to the start of the current open fold.  If already at the
		start, move to the start of the fold that contains it.  If
		there is no containing fold, the command fails.
		When a count is used, repeats the command [count] times.
							]z
]z		Move to the end of the current open fold.  If already at the
		end, move to the end of the fold that contains it.  If there
		is no containing fold, the command fails.
		When a count is used, repeats the command [count] times.
							zj
zj		Move downwards to the start of the next fold.  A closed fold
		is counted as one fold.
		When a count is used, repeats the command [count] times.
		This command can be used after an operator.
							zk
zk		Move upwards to the end of the previous fold.  A closed fold
		is counted as one fold.
		When a count is used, repeats the command [count] times.
		This command can be used after an operator.
EXECUTING COMMANDS ON FOLDS
:[range]foldd[oopen] {cmd}			:foldd :folddo :folddoopen
		Execute {cmd} on all lines that are not in a closed fold.
		When [range] is given, only these lines are used.
		Each time {cmd} is executed the cursor is positioned on the
		line it is executed for.
		This works like the ":global" command: First all lines that
		are not in a closed fold are marked.  Then the {cmd} is
		executed for all marked lines.  Thus when {cmd} changes the
		folds, this has no influence on where it is executed (except
		when lines are deleted, of course).
		Example:
:folddoopen s/end/loop_end/ge
		Note the use of the "e" flag to avoid getting an error message
		where "end" doesn't match.
:[range]folddoc[losed] {cmd}			:folddoc :folddoclosed
		Execute {cmd} on all lines that are in a closed fold.
		Otherwise like ":folddoopen".
